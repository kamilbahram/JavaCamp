package com.example.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.bussines.absracts.ProductService;
import com.example.northwind.bussines.request.create.CreateProductsRequest;
import com.example.northwind.bussines.request.update.UpdateProductRequest;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.ErrorDataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategory;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;  
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
		(MethodArgumentNotValidException exceptions){
			Map<String,String> validationErrors = new HashMap<String, String>();
			for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}			
			ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
			return errors;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();		
	}
	
	@GetMapping("/getallDesc")
	public DataResult<List<Product>> getAllDesc(@RequestParam String productName) {
		return this.productService.findByProductNameOrderByProductNameDesc(productName);		
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
	public DataResult<List<Product>> getByCategoryIdIn(@RequestBody  List<Integer> categories){
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
	
	@PutMapping("/update")
	public DataResult<Product> update(@RequestBody Product product){
		return this.productService.update(product);
	}
	
	@GetMapping("/getAll2")
	public ResponseEntity<?> getAll2(){
		return ResponseEntity.ok(this.productService.getAll2());
	}
	@PostMapping("/add2")
	public ResponseEntity<?> add2(@Valid @RequestBody CreateProductsRequest createProductsRequest){
		return ResponseEntity.ok(this.productService.add2(createProductsRequest));
	}
	@PutMapping("/update2")
	public ResponseEntity<?> update2(@Valid @RequestBody UpdateProductRequest updateProductRequest){
		return ResponseEntity.ok(this.productService.update2(updateProductRequest));
	}
		
}