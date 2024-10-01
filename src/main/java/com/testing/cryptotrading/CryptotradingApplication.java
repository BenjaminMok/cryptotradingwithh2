package com.testing.cryptotrading;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.testing.cryptotrading.user.*;
import com.testing.cryptotrading.crypto.*;

@Component
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class CryptotradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptotradingApplication.class, args);

		System.out.println("Application succesfully launched");

		
	}
	@Bean
    CommandLineRunner loadDataCustomer(CustomerRepository customerRepository) {
        return args -> {
            // Insert sample data into the database
            customerRepository.save(new Customer("David","david@gmail.com",50000.00));
            customerRepository.save(new Customer("Jas", "jas@gmail.com", 50000.00));
        };
    }

	@Bean
    CommandLineRunner loadDataCrypto(CryptoRepository cryptoRepository) {
        return args -> {
            // Insert sample data into the database
            cryptoRepository.save(new Crypto("ETHUSDT", 0.0, 0.0));
            cryptoRepository.save(new Crypto("BTCUSDT", 0.0, 0.0));
        };
    }

}
