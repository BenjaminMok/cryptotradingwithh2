package com.testing.cryptotrading.crypto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testing.cryptotrading.user.Customer;


@RestController
@RequestMapping("/api/v1")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;


    @GetMapping("/ticker")
    public List<Crypto> getBestAggregatedPrice() {
        return (List<Crypto>) cryptoService.fetchCryptoList();
    }
    
    @Scheduled(fixedRate = 10000) //10secs interval
    public void updateBestAggregatedPrice() {
        List<BinanceCrypto> binanceArray = getBinanceTickerData();
        List<HuobiCrypto> huobiArray = getHoubiTickerData();
        
        for (BinanceCrypto binanceCrypto : binanceArray) {
            for (HuobiCrypto huobiCrypto : huobiArray) {
                // Check if the symbols match (case insensitive)
                if (binanceCrypto.getSymbol().equalsIgnoreCase(huobiCrypto.getSymbol())) {
                    double binanceBidPrice = binanceCrypto.getBidPrice();
                    double huobiBidPrice = huobiCrypto.getBid();
                    double lowerBid = Math.min(binanceBidPrice, huobiBidPrice);

                    double binanceAskPrice = binanceCrypto.getBidPrice();
                    double huobiAskPrice = huobiCrypto.getBid();
                    double higherAsk = Math.max(binanceAskPrice, huobiAskPrice);

                    System.out.println("bid" + lowerBid);
                    System.out.println("ask" + higherAsk);
                    cryptoService.updateCrypto(binanceCrypto.getSymbol(), lowerBid, higherAsk);
                }
            }
        }
    }


    // Endpoint to get the data from Binance API
    //@GetMapping("/binance")
    public List<BinanceCrypto> getBinanceTickerData() {
        String url = "https://api.binance.com/api/v3/ticker/bookTicker";
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Make the GET request
            BinanceCrypto[] response = restTemplate.getForObject(url, BinanceCrypto[].class);
            List<BinanceCrypto> binanceArray = new ArrayList<>();

            for (BinanceCrypto binanceCrypto : response) {
                if(binanceCrypto.getSymbol().equalsIgnoreCase("ETHUSDT") || binanceCrypto.getSymbol().equalsIgnoreCase("BTCUSDT")){
                    binanceArray.add(binanceCrypto);
                }
            }
            return binanceArray;

        } catch (RestClientException e) {
            // logger.error("Error occurred while fetching data from Binance: {}",
            // e.getMessage());
            throw new RuntimeException("Error occurred while fetching data from Binance API", e); // Re-throwing the exception so Spring will handle it
        }
    }

    // Endpoint to get the data from Houbi API
    //@GetMapping("/huobi")
    public List<HuobiCrypto> getHoubiTickerData() {
        String url = "https://api.huobi.pro/market/tickers";
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Make the GET request
            JsonNode response = restTemplate.getForObject(url, JsonNode.class);
            JsonNode data = response.get("data");
            HuobiCrypto[] dataObject = objectMapper.treeToValue(data, HuobiCrypto[].class);
            List<HuobiCrypto> houbiArray = new ArrayList<>();
            for (HuobiCrypto houbiCrypto : dataObject) {
                if(houbiCrypto.getSymbol().equalsIgnoreCase("ETHUSDT") || houbiCrypto.getSymbol().equalsIgnoreCase("BTCUSDT")){
                    houbiArray.add(houbiCrypto);
                }
            }
            return houbiArray;

        } catch (RestClientException e) {
            throw new RuntimeException("Error occurred while fetching data from Huobi API", e); // Re-throwing the exception so Spring will handle it
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error mapping data to HoubiCrypto class", e);
        }
    }
}
