package com.testing.cryptotrading.crypto;
import java.util.Objects;

public class BinanceCrypto {
    private String symbol;
    private double bidPrice;
    private double bidQty;
    private double askPrice;
    private double askQty;


    public BinanceCrypto() {
    }

    public BinanceCrypto(String symbol, double bidPrice, double bidQty, double askPrice, double askQty) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getBidPrice() {
        return this.bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getBidQty() {
        return this.bidQty;
    }

    public void setBidQty(double bidQty) {
        this.bidQty = bidQty;
    }

    public double getAskPrice() {
        return this.askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public double getAskQty() {
        return this.askQty;
    }

    public void setAskQty(double askQty) {
        this.askQty = askQty;
    }

    public BinanceCrypto symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public BinanceCrypto bidPrice(double bidPrice) {
        setBidPrice(bidPrice);
        return this;
    }

    public BinanceCrypto bidQty(double bidQty) {
        setBidQty(bidQty);
        return this;
    }

    public BinanceCrypto askPrice(double askPrice) {
        setAskPrice(askPrice);
        return this;
    }

    public BinanceCrypto askQty(double askQty) {
        setAskQty(askQty);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BinanceCrypto)) {
            return false;
        }
        BinanceCrypto binanceCrypto = (BinanceCrypto) o;
        return Objects.equals(symbol, binanceCrypto.symbol) && bidPrice == binanceCrypto.bidPrice && bidQty == binanceCrypto.bidQty && askPrice == binanceCrypto.askPrice && askQty == binanceCrypto.askQty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, bidPrice, bidQty, askPrice, askQty);
    }

    @Override
    public String toString() {
        return "{" +
            " symbol='" + getSymbol() + "'" +
            ", bidPrice='" + getBidPrice() + "'" +
            ", bidQty='" + getBidQty() + "'" +
            ", askPrice='" + getAskPrice() + "'" +
            ", askQty='" + getAskQty() + "'" +
            "}";
    }
    
}