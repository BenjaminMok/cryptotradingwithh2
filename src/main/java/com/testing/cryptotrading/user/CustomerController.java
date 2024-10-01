package com.testing.cryptotrading.user;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public List<Customer> fetchCustomerList() {
        return customerService.fetchCustomerList();
    }

    // Retrieve all customer details with input of customer name
    @GetMapping("/customers/name")
    @ResponseBody
    public List<Customer> getCutomerByName(@RequestParam String custName) {
        return customerService.findByCustName(custName);
    }

    // Retreive customer balance with input of customer name
    @GetMapping("/customers/balance")
    @ResponseBody
    public String getBalanceByName(@RequestParam String custName) {
        List<Customer> resultCustomer = customerService.findByCustName(custName);
        if(resultCustomer.size() == 1){
            return "Balance of "+resultCustomer.get(0).getCustName()+ " is $"+ resultCustomer.get(0).getAccountBalance();
        }
        return null;
    }
    
}
