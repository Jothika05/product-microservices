package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.example.repo.*;
import com.example.entity.Product;

@EnableEurekaClient
@SpringBootApplication
public class StoreappApplication implements CommandLineRunner {
   @Autowired
   @Qualifier("productRepository")
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(StoreappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productRepository.save(new Product(null, "Tv", "LG", 7886.0));
		productRepository.save(new Product(null, "Computer", "Dell", 789386.0));
		productRepository.save(new Product(null, "Mobile", "Redmi", 78746.0));
	}

}