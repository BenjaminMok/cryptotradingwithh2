package com.testing.cryptotrading.wallet;

import com.testing.cryptotrading.user.Customer;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Objects;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @Column(nullable = false, length = 255)
    private String customerName;

    @Column(nullable = false)
    private HashMap<String, Double> walletMap;

    public Wallet() {
    }

    public Wallet(Long id, Customer customer, String customerName, HashMap<String,Double> walletMap) {
        this.id = id;
        this.customer = customer;
        this.customerName = customerName;
        this.walletMap = walletMap;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String,Double> getWalletMap() {
        return this.walletMap;
    }

    public void setWalletMap(HashMap<String,Double> walletMap) {
        this.walletMap = walletMap;
    }

    public Wallet id(Long id) {
        setId(id);
        return this;
    }

    public Wallet customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    public Wallet customerName(String customerName) {
        setCustomerName(customerName);
        return this;
    }

    public Wallet walletMap(HashMap<String,Double> walletMap) {
        setWalletMap(walletMap);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Wallet)) {
            return false;
        }
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(customer, wallet.customer) && Objects.equals(customerName, wallet.customerName) && Objects.equals(walletMap, wallet.walletMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, customerName, walletMap);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", walletMap='" + getWalletMap() + "'" +
            "}";
    }


}

