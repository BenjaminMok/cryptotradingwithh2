package com.testing.cryptotrading.crypto;
import java.util.Objects;

public class HuobiCrypto {
    private String symbol;
    private double open;
    private double high;
    private double low;
    private double close;
    private double amount;
    private double vol;
    private int count;
    private double bid;
    private double bidSize;
    private double ask;
    private double askSize;


    public HuobiCrypto() {
    }


    public HuobiCrypto(String symbol, double open, double high, double low, double close, double amount, double vol, int count, double bid, double bidSize, double ask, double askSize) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.amount = amount;
        this.vol = vol;
        this.count = count;
        this.bid = bid;
        this.bidSize = bidSize;
        this.ask = ask;
        this.askSize = askSize;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getOpen() {
        return this.open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return this.high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return this.low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return this.close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getVol() {
        return this.vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getBid() {
        return this.bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getBidSize() {
        return this.bidSize;
    }

    public void setBidSize(double bidSize) {
        this.bidSize = bidSize;
    }

    public double getAsk() {
        return this.ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getAskSize() {
        return this.askSize;
    }

    public void setAskSize(double askSize) {
        this.askSize = askSize;
    }

    public HuobiCrypto symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public HuobiCrypto open(double open) {
        setOpen(open);
        return this;
    }

    public HuobiCrypto high(double high) {
        setHigh(high);
        return this;
    }

    public HuobiCrypto low(double low) {
        setLow(low);
        return this;
    }

    public HuobiCrypto close(double close) {
        setClose(close);
        return this;
    }

    public HuobiCrypto amount(double amount) {
        setAmount(amount);
        return this;
    }

    public HuobiCrypto vol(double vol) {
        setVol(vol);
        return this;
    }

    public HuobiCrypto count(int count) {
        setCount(count);
        return this;
    }

    public HuobiCrypto bid(double bid) {
        setBid(bid);
        return this;
    }

    public HuobiCrypto bidSize(double bidSize) {
        setBidSize(bidSize);
        return this;
    }

    public HuobiCrypto ask(double ask) {
        setAsk(ask);
        return this;
    }

    public HuobiCrypto askSize(double askSize) {
        setAskSize(askSize);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HuobiCrypto)) {
            return false;
        }
        HuobiCrypto houbiCrypto = (HuobiCrypto) o;
        return Objects.equals(symbol, houbiCrypto.symbol) && open == houbiCrypto.open && high == houbiCrypto.high && low == houbiCrypto.low && close == houbiCrypto.close && amount == houbiCrypto.amount && vol == houbiCrypto.vol && count == houbiCrypto.count && bid == houbiCrypto.bid && bidSize == houbiCrypto.bidSize && ask == houbiCrypto.ask && askSize == houbiCrypto.askSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, open, high, low, close, amount, vol, count, bid, bidSize, ask, askSize);
    }

    @Override
    public String toString() {
        return "{" +
            " symbol='" + getSymbol() + "'" +
            ", open='" + getOpen() + "'" +
            ", high='" + getHigh() + "'" +
            ", low='" + getLow() + "'" +
            ", close='" + getClose() + "'" +
            ", amount='" + getAmount() + "'" +
            ", vol='" + getVol() + "'" +
            ", count='" + getCount() + "'" +
            ", bid='" + getBid() + "'" +
            ", bidSize='" + getBidSize() + "'" +
            ", ask='" + getAsk() + "'" +
            ", askSize='" + getAskSize() + "'" +
            "}";
    }
  
}
