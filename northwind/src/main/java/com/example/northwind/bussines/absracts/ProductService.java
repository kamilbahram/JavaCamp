package com.example.northwind.bussines.absracts;

import java.util.List;

import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.entities.concretes.Product;

public interface ProductService {
	//List<Product> getAll();
	DataResult<List<Product>> getAll();
	Result add(Product product);
}
