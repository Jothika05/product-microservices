package com.example.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.proxy.ProductServiceProxy;

import ch.qos.logback.classic.Logger;

@RestController  
@Scope("request")
public class ProductClientController {

	@Autowired
	private ProductServiceProxy productServiceProxy;
	private static final Logger Log = (Logger) LoggerFactory.getLogger(ProductClientController.class);

	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		Log.debug("In getProductbyld with Id:" + id);

		Product product = productServiceProxy.getProductById(id);
		Log.debug("In get ProductById with return value product: " + product);
		return product;
	}

	@GetMapping("/get-products")
	public List<Product> gettAllProducts() {

		List<Product> products = productServiceProxy.getAllProducts();
		Log.debug("In gettAllProducts  with return value product: " + products);
		return products;

	}
}
