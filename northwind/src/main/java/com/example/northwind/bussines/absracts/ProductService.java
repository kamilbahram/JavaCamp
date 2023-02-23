package com.example.northwind.bussines.absracts;

import java.util.List;

import com.example.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
}
