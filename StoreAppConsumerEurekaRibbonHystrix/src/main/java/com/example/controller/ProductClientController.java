package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.Product;
import com.example.service.ProductService;
@RestController
@Scope("request")
public class ProductClientController {
	@Autowired
	private ProductService productService;
	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
}
