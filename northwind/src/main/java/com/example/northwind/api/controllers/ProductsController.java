package com.example.northwind.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.bussines.absracts.ProductService;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategory;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
	}
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);		
	}
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}
	@GetMapping("/getByProductNameOrCategory_CategoryId")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);		
	}	
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam("categories[]")  List<Integer> categories){
		return this.productService.getByCategory_CategoryIdIn(categories);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
		return this.productService.getAll(pageNo, pageSize);		
	}
	@GetMapping("/getAllSordetDesc")
	public DataResult<List<Product>> getAllSordetDesc(){
		return this.productService.getAllSorted();
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategory>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
}