package com.testing.cryptotrading.crypto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CryptoService {
    @Autowired
    private CryptoRepository cryptoRepository;

    // Method to update the crypto details in the database
    public Crypto updateCrypto(String symbol, double bidPrice, double askPrice) {
        Optional<Crypto> cryptoOptional = cryptoRepository.findBySymbol(symbol);
        if (cryptoOptional.isPresent()) {
            Crypto crypto = cryptoOptional.get();
            crypto.setBidPrice(bidPrice);
            crypto.setAskPrice(askPrice);
            return cryptoRepository.save(crypto); // Persist updated crypto
        }
        return null; // Crypto symbol not found
    }

    // Read operation
    //Get all customers
    public List<Crypto> fetchCryptoList() {
        return (List<Crypto>) cryptoRepository.findAll();
    }
}
