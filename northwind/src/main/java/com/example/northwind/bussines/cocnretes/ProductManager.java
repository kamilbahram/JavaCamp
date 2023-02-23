package com.example.northwind.bussines.cocnretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.bussines.absracts.ProductService;
import com.example.northwind.dataAccess.absracts.ProductDao;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{
	
	ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
	
		return this.productDao.findAll();
	}
	

}
