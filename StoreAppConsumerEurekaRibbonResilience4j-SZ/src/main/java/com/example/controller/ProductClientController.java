package com.example.controller;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.Product;
import com.example.service.ProductService;
import ch.qos.logback.classic.Logger;
@RestController
@Scope("request")
public class ProductClientController {
	@Autowired
	private ProductService productService;
	private static final Logger Log=(Logger) LoggerFactory.getLogger(ProductClientController.class);
	@GetMapping("/get-products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		Log.debug("In getProductbyld with Id:"+id);
		Product product=productService.getProductById(id);
		Log.debug("In get ProductById with return value product: "+product);
		return product;
	}
}
