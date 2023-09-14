package com.example.service;
import java.util.List;

import com.example.entity.*;
public interface IProductservice {
	public Product addproduct(Product product);
	public Product updateProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProductById(Integer id);
	public void deleteProductByid(Integer id); 

	public List<Product> findbyName(String name);
	public List<Product> findbyBrand(String brand);
	public List<Product> findbyPrice(double price);
}