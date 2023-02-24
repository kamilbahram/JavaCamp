package com.example.northwind.bussines.cocnretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.bussines.absracts.ProductService;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.core.utilities.result.SuccessDataResult;
import com.example.northwind.core.utilities.result.SuccessResult;
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
	public DataResult<List<Product>> getAll() {
	
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(), "SuccessData deneniyor!!!");
	}
/*
	@Override
	public List<Product> getAll() {
	
		return this.productDao.findAll();
	}
*/

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}
	

}
