package com.testing.cryptotrading.user;

import jakarta.persistence.*;
import java.util.Objects;

@Entity

public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(nullable = false, length = 255)
    private String custName;
     
    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false)
    private double accountBalance;

    public Customer() {
    }

    public Customer(String custName, String email, double accountBalance) {
        this.custName = custName;
        this.email = email;
        this.accountBalance = accountBalance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return this.custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Customer id(int id) {
        setId(id);
        return this;
    }

    public Customer custName(String custName) {
        setCustName(custName);
        return this;
    }

    public Customer email(String email) {
        setEmail(email);
        return this;
    }

    public Customer accountBalance(double accountBalance) {
        setAccountBalance(accountBalance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(custName, customer.custName) && Objects.equals(email, customer.email) && accountBalance == customer.accountBalance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custName, email, accountBalance);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", custName='" + getCustName() + "'" +
            ", email='" + getEmail() + "'" +
            ", accountBalance='" + getAccountBalance() + "'" +
            "}";
    }
    
}