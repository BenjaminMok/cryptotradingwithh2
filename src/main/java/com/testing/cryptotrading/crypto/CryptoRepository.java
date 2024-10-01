package com.testing.cryptotrading.crypto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long> {

    Optional<Crypto> findBySymbol(String symbol);
}