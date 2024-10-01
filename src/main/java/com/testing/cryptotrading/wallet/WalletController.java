package com.testing.cryptotrading.wallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/wallets")
    public List<Wallet> fetchCustomerList() {
        return walletService.fetchWalletist();
    }

    // Retrieve all customer details with input of customer name
    @GetMapping("/wallets/name")
    @ResponseBody
    public List<Wallet> getCutomerByName(@RequestParam String custName) {
        return walletService.findByCustName(custName);
    }
}
