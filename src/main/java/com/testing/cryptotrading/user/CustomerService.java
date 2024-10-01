package com.testing.cryptotrading.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save operation
    Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Read operation
    //Get all customers
    public List<Customer> fetchCustomerList() {
        return (List<Customer>) customerRepository.findAll();
    }

    //Get customer based on name
    public List<Customer> findByCustName(String custName){
        return customerRepository.findByCustName(custName);
    }

}
