package com.testing.cryptotrading.transaction;

import jakarta.persistence.*;
import com.testing.cryptotrading.user.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @Column(nullable = false, length = 255)
    private String customerName;

    @Column(nullable = false, length = 255)
    private String cryptoPair;

    @Column(nullable = false, length = 255)
    private String transactionType; // BUY or SELL

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Getters and setters

    public Transaction() {
    }

    public Transaction(Long id, String customerName, String cryptoPair, String transactionType, Double quantity, Double price, LocalDateTime timestamp) {
        this.id = id;
        this.customerName = customerName;
        this.cryptoPair = cryptoPair;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCryptoPair() {
        return this.cryptoPair;
    }

    public void setCryptoPair(String cryptoPair) {
        this.cryptoPair = cryptoPair;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Transaction id(Long id) {
        setId(id);
        return this;
    }

    public Transaction customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    public Transaction cryptoPair(String cryptoPair) {
        setCryptoPair(cryptoPair);
        return this;
    }

    public Transaction transactionType(String transactionType) {
        setTransactionType(transactionType);
        return this;
    }

    public Transaction quantity(Double quantity) {
        setQuantity(quantity);
        return this;
    }

    public Transaction price(Double price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id) && Objects.equals(customer, transaction.customer)
                && Objects.equals(cryptoPair, transaction.cryptoPair)
                && Objects.equals(transactionType, transaction.transactionType)
                && Objects.equals(quantity, transaction.quantity) && Objects.equals(price, transaction.price)
                && Objects.equals(timestamp, transaction.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, cryptoPair, transactionType, quantity, price, timestamp);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", customer='" + getCustomer() + "'" +
                ", cryptoPair='" + getCryptoPair() + "'" +
                ", transactionType='" + getTransactionType() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", price='" + getPrice() + "'" +
                ", timestamp='" + getTimestamp() + "'" +
                "}";
    }

}