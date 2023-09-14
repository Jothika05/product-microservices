package com.example.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
   
	private Integer id;

	 private String name;
   
	 private String brand;

	 private double price;
}
