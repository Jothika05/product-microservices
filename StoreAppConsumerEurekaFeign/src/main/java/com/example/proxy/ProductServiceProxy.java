package com.example.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.domain.Product;

@FeignClient("product-service")
public interface ProductServiceProxy {
	
	@GetMapping (value = "/products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
      public Product getProductById(@PathVariable ("id") Integer id);

	@GetMapping (value="/products", produces= {MediaType.APPLICATION_JSON_VALUE}) 
	  public List<Product> getAllProducts();
	}
