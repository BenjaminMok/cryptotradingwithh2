package com.testing.cryptotrading.wallet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepositoy walletRepository;

    // Save operation
    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    // Read operation
    // Get all wallets
    public List<Wallet> fetchWalletist() {
        return (List<Wallet>) walletRepository.findAll();
    }

    // Get Wallet based on name
    public List<Wallet> findByCustName(String custName) {
        return walletRepository.findByCustomerName(custName);
    }
}
