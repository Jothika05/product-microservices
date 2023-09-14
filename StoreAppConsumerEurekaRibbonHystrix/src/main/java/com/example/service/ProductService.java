package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class ProductService {
	@Autowired
	private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "fallbackMethodForGetProductById")
	public Product getProductById(int id) {
		Product product = restTemplate.getForObject("http:/product-service/products/" + id,
				Product.class);
		return product;
	}
	public Product fallbackMethodForGetProductById(int id) {
		return new Product(id, "Monitor", "Jio", 34343.0);
	}
}
