package com.testing.cryptotrading.transaction;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // Save operation
    Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Read operation
    //Get all transactions
    public List<Transaction> fetchTransactionist() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    //Get Transaction based on name
    public List<Transaction> findByCustName(String custName){
        return transactionRepository.findByCustomerName(custName);
    }

    //Get Transaction based on id
    public Optional<Transaction> findById(Long Id){
        return transactionRepository.findById(Id);
    }
}
