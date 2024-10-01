// package com.testing.cryptotrading.user;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// // Annotation
// @Service

// // Class
// public class CustomerServiceImplement
//     implements CustomerService {

//     @Autowired
//     private CustomerRepository customerRepository;

//     // Save operation
//     @Override
//     public Customer saveCustomer(Customer customer)
//     {
//         return customerRepository.save(customer);
//     }

//     // Read operation
//     @Override public List<Customer> fetchCustomerList()
//     {
//         return (List<Customer>)
//         customerRepository.findAll();
//     }

//     // Update operation
//     @Override
//     public Customer
//     updateCustomer(Customer customer, Long customerId)
//     {
//         return new Customer();
//     }

//     // Delete operation
//     @Override
//     public void deleteCustomerById(Long customerId)
//     {
//         customerRepository.deleteById(customerId);
//     }
// }