package com.testing.cryptotrading.crypto;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Crypto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String symbol;

    @Column(nullable = false)
    private double bidPrice;

    @Column(nullable = false)
    private double askPrice;


    public Crypto() {
    }

    public Crypto(String symbol, double bidPrice, double askPrice) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public double getBidPrice() {
        return this.bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getAskPrice() {
        return this.askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Crypto)) {
            return false;
        }
        Crypto crypto = (Crypto) o;
        return Objects.equals(symbol, crypto.symbol) && bidPrice == crypto.bidPrice && askPrice == crypto.askPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, bidPrice, askPrice);
    }

    @Override
    public String toString() {
        return "{" +
            " symbol='" + getSymbol() + "'" +
            ", bidPrice='" + getBidPrice() + "'" +
            ", askPrice='" + getAskPrice() + "'" +
            "}";
    }
    
}
