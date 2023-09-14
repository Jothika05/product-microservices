package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.proxy.ProductServiceProxy;

@RestController
@Scope("request")
public class ProductClientController {

	@Autowired
	private ProductServiceProxy productServiceProxy;

	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {

		Product product = productServiceProxy.getProductById(id);

		return product;
	}

	@GetMapping("/get-products")
	public List<Product> gettAllProducts() {

		List<Product> products = productServiceProxy.getAllProducts();

		return products;

	}
}
