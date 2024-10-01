package com.testing.cryptotrading.wallet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepositoy extends JpaRepository<Wallet,Long> {
    List<Wallet> findByCustomerName(String customerName);

}
