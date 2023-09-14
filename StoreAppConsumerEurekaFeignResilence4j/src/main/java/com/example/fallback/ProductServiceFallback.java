package com.example.fallback;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.domain.Product;
import com.example.proxy.ProductServiceProxy;
@Component
public class ProductServiceFallback implements ProductServiceProxy{
	@Override
	public Product getProductById(Integer id) {
		
		
		return new Product(id,"Monitor","Jio",34343.0);
	}
	@Override
	public List<Product> getAllProducts() {
	
		return new ArrayList<Product>();
	}
}

