package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.IProductservice;


@RestController
@Scope(value = "request")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private IProductservice productservice;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productservice.addproduct(product);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(code = HttpStatus.OK)
    public Product updateProduct(@RequestBody Product product) {
        return productservice.updateProduct(product);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> fetchAllProducts() {
        return productservice.getAllProducts();
    }

    @GetMapping(value = "/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product fetchSingleProduct(@PathVariable("product_id") Integer productId) {
        return productservice.getProductById(productId);
    }

    @DeleteMapping(value = "/{product_id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("product_id") Integer productId) {
        productservice.deleteProductByid(productId);
    }

    @GetMapping(value = "/name/{product_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> fetchProductsByName(@PathVariable("product_name") String productName) {
        return productservice.findbyName(productName);
    }

    @GetMapping(value = "/brand/{product_brand}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> fetchProductsByBrand(@PathVariable("product_brand") String productBrand) {
        return productservice.findbyBrand(productBrand);
    }
 
    @GetMapping(value = "/price/{product_price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> fetchProductsByPrice(@PathVariable("product_price") double productPrice) {
        return productservice.findbyPrice(productPrice);
    }
}



   