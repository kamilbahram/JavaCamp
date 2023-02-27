package com.example.northwind.bussines.cocnretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.northwind.bussines.absracts.ProductService;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.core.utilities.result.SuccessDataResult;
import com.example.northwind.core.utilities.result.SuccessResult;
import com.example.northwind.dataAccess.absracts.ProductDao;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategory;

import net.bytebuddy.asm.Advice.This;


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

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName), "Ürün getirildi!!!");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Ürün ve categoriy!!!");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Ürün veya category geliyor!!!");
	}

	@Override
	public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories), "Verilen kategoriy listesi getirildi!!!");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName), "Üründen var!!!");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName), "Girilen karakterin bulunduğu ürünler çekiliyor!!!");
	} 
/*
	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryID) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryID), "Ürün ve categoriler!!!");
	}  */

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int PageSize) {
		Pageable pageable= PageRequest.of(pageNo, PageSize);
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		//düzenleme yapılmalı 
		org.springframework.data.domain.Sort sort = 
		org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.DESC, "productName");
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(sort),"Sıralama başarılı");
		
	}

	@Override
	public DataResult<List<ProductWithCategory>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategory>> 
	(this.productDao.getProductWithCategoryDetails(), "inner join product with category");
	}
		
}
 