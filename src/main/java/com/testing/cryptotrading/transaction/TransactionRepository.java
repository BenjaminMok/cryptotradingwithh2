package com.testing.cryptotrading.transaction;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>  {
    List<Transaction> findByCustomerName(String customerName);

    Optional<Transaction> findById(Long Id);
}
