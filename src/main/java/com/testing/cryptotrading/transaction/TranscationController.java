package com.testing.cryptotrading.transaction;

import org.springframework.web.bind.annotation.RestController;

import com.testing.cryptotrading.crypto.Crypto;
import com.testing.cryptotrading.crypto.CryptoService;
import com.testing.cryptotrading.user.Customer;
import com.testing.cryptotrading.user.CustomerService;
import com.testing.cryptotrading.wallet.Wallet;
import com.testing.cryptotrading.wallet.WalletService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/v1")

public class TranscationController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CryptoService cryptoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WalletService walletService;

    @GetMapping("/transcations")
    public List<Transaction> fetchTransactionist() {
        return transactionService.fetchTransactionist();
    }

    @GetMapping("/transactions/history")
    @ResponseBody
    public List<Transaction> getTransactionHistoryByCustomer(@RequestParam String customer) {
        return transactionService.findByCustName(customer);
    }

    @PostMapping("/openTrade")
    public String placeTrade(@RequestParam String customerName, @RequestParam String cryptoPair,
            @RequestParam double quantity, @RequestParam String action) {

        List<Crypto> cryptoPricing = cryptoService.searchBySymbol(cryptoPair);
        List<Customer> customerInfo = customerService.findByCustName(customerName);
        List<Wallet> walletInfo = walletService.findByCustName(customerName);

        Customer currentCustomer = customerInfo.get(0);

        Transaction transaction = new Transaction();
        double totalCost = quantity;
        transaction.setCustomer(currentCustomer);
        transaction.setCustomerName(customerName);
        transaction.setCryptoPair(cryptoPair);
        transaction.setTransactionType(action);
        transaction.setQuantity(quantity);
        transaction.setTimestamp(LocalDateTime.now());

        if (action.equalsIgnoreCase("BUY")) {
            double askPrice = cryptoPricing.get(0).getAskPrice();
            transaction.setPrice(askPrice);
            totalCost *= askPrice;
            if (currentCustomer.getAccountBalance() < totalCost) {
                return "Trade executed failed! Insufficient balance!";
            }
        } else if (action.equalsIgnoreCase("SELL")) {
            double bidPrice = cryptoPricing.get(0).getBidPrice();
            transaction.setPrice(bidPrice);
            totalCost *= bidPrice;
            if (currentCustomer.getAccountBalance() < totalCost) {
                return "Trade executed failed! Insufficient balance!";

            }
        } else {
            return "Invalid action!";
        }

        if (walletInfo.isEmpty()) {
            Wallet wallet = new Wallet();
            wallet.setCustomer(currentCustomer);
            wallet.setCustomerName(customerName);
            HashMap<String, Double> walletmap = new HashMap<>();
            walletmap.put(cryptoPair, quantity);
            wallet.setWalletMap(walletmap);
            walletService.saveWallet(wallet);
        } else {
            for (Wallet wallet : walletInfo) {
                HashMap<String, Double> currentMap = wallet.getWalletMap();

                if (currentMap.containsKey(cryptoPair)) {
                    if (action.equalsIgnoreCase("BUY")) {
                        currentMap.put(cryptoPair, currentMap.get(cryptoPair) + quantity);
                    } else if (action.equalsIgnoreCase("SELL")) {
                        currentMap.put(cryptoPair, currentMap.get(cryptoPair) - quantity);
                    } else {
                        return "Invalid action!";
                    }
                } else {
                    HashMap<String, Double> walletmap = wallet.getWalletMap();
                    walletmap.put(cryptoPair, quantity);
                }
                walletService.saveWallet(wallet);
            }
        }
        currentCustomer.setAccountBalance(currentCustomer.getAccountBalance() - totalCost);
        transaction.setStatus("Open");
        transaction.setTotalAmount(totalCost);
        transactionService.saveTransaction(transaction);

        return "Trade executed successfully!";

    }

    @PostMapping("/closeTrade")
    public String closedTrade(@RequestParam Long Id, @RequestParam String customerName) {
        Optional<Transaction> transactions = transactionService.findById(Id);
        List<Customer> customerInfo = customerService.findByCustName(customerName);

        Customer currentCustomer = customerInfo.get(0);

        Transaction currentTransaction = transactions.get();
        List<Wallet> walletInfo = walletService.findByCustName(customerName);

        double totalPL = currentTransaction.getQuantity();

        List<Crypto> cryptoPricing = cryptoService.searchBySymbol(currentTransaction.getCryptoPair());

        if (currentTransaction.getStatus().equalsIgnoreCase("Closed")) {
            return "Trade had been closed.";
        }

        if (currentTransaction.getTransactionType().equalsIgnoreCase("BUY")) {
            double bidPrice = cryptoPricing.get(0).getBidPrice();
            totalPL *= bidPrice;
        } else if (currentTransaction.getTransactionType().equalsIgnoreCase("SELL")) {
            double askPrice = cryptoPricing.get(0).getAskPrice();
            totalPL *= askPrice;
        } else {
            return "Invalid action!";
        }

        for (Wallet wallet : walletInfo) {
            HashMap<String, Double> currentMap = wallet.getWalletMap();

            if (currentTransaction.getTransactionType().equalsIgnoreCase("BUY")) {
                currentMap.put(currentTransaction.getCryptoPair(),
                        currentMap.get(currentTransaction.getCryptoPair()) - currentTransaction.getQuantity());
            } else if (currentTransaction.getTransactionType().equalsIgnoreCase("SELL")) {
                currentMap.put(currentTransaction.getCryptoPair(),
                        currentMap.get(currentTransaction.getCryptoPair()) + currentTransaction.getQuantity());
            } else {
                return "Invalid action!";
            }

            walletService.saveWallet(wallet);
        }

        currentCustomer.setAccountBalance(currentCustomer.getAccountBalance() + totalPL);
        currentTransaction.setStatus("Closed");
        currentTransaction.setTotalAmount(totalPL);
        transactionService.saveTransaction(currentTransaction);

        return "Trade closed successfully!";
    }
}
