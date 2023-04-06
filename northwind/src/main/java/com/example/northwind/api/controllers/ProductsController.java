package com.example.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.northwind.bussines.request.delete.RequestProductDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<?> getAllDesc(@RequestParam String productName) {
		return ResponseEntity.ok(this.productService.findByProductNameOrderByProductNameDesc(productName));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Product product) {
		return ResponseEntity.ok(this.productService.add(product));
	}
	@GetMapping("/getByProductName")
	public ResponseEntity<?> getByProductName(@RequestParam String productName) {
		return ResponseEntity.ok(this.productService.getByProductName(productName));
	}
	@GetMapping("/getByProductNameAndCategory")
	public ResponseEntity<?> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
		return ResponseEntity.ok(this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId));
	}
	@GetMapping("/getByProductNameOrCategory_CategoryId")
	public ResponseEntity<?> getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return ResponseEntity.ok(this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId));
	}	
	@GetMapping("/getByCategoryIdIn")
	public ResponseEntity<?> getByCategoryIdIn(@RequestBody  List<Integer> categories){
		return ResponseEntity.ok(this.productService.getByCategory_CategoryIdIn(categories));
	}
	@GetMapping("/getByProductNameContains")
	public ResponseEntity<?> getByProductNameContains(@RequestParam String productName){
		return ResponseEntity.ok(this.productService.getByProductNameContains(productName));
	}
	@GetMapping("/getByProductNameStartsWith")
	public ResponseEntity<?> getByProductNameStartsWith(@RequestParam String productName){
		return ResponseEntity.ok(this.productService.getByProductNameStartsWith(productName));
	}
	@GetMapping("/getAllByPage")
	public ResponseEntity<?> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
		return ResponseEntity.ok(this.productService.getAll(pageNo, pageSize));
	}
	@GetMapping("/getAllSordetDesc")
	public ResponseEntity<?> getAllSordetDesc(){
		return ResponseEntity.ok(this.productService.getAllSorted());
	}
	@GetMapping("/getProductWithCategoryDetails")
	public ResponseEntity<?> getProductWithCategoryDetails(){
		return ResponseEntity.ok(this.productService.getProductWithCategoryDetails());
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Product product){
		return ResponseEntity.ok(this.productService.update(product));
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
	@DeleteMapping("/Delete")
	public ResponseEntity<?> delete(@Valid @RequestBody RequestProductDelete requestProductDelete){
		return ResponseEntity.ok(this.productService.delete(requestProductDelete));
	}
		
}