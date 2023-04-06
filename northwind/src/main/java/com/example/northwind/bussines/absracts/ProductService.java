package com.example.northwind.bussines.absracts;

import java.util.List;

import com.example.northwind.bussines.request.create.CreateProductsRequest;
import com.example.northwind.bussines.request.delete.RequestProductDelete;
import com.example.northwind.bussines.request.update.UpdateProductRequest;
import com.example.northwind.bussines.response.GetAllProductsResponse;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategory;

public interface ProductService {

	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAll(int pageNo, int PageSize);
	Result add(Product product);
	DataResult<Product> getByProductName(String productName);
	DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);
	DataResult<List<Product>> getByProductNameContains(String productName);
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	//DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	DataResult<List<ProductWithCategory>> getProductWithCategoryDetails();
	DataResult<List<Product>> findByProductNameOrderByProductNameDesc(String productName);
	// Update
	DataResult<Product> update(Product product);

	// Reguest and Resbonse imzalarının uygulanışı
	DataResult<List<GetAllProductsResponse>> getAll2();
	DataResult<CreateProductsRequest> add2(CreateProductsRequest createProductsRequest);
	DataResult<UpdateProductRequest> update2(UpdateProductRequest updateProductRequest);
	DataResult<RequestProductDelete> delete(RequestProductDelete requestProductDelete);

}
