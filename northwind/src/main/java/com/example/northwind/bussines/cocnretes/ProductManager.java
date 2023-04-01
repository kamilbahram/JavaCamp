package com.example.northwind.bussines.cocnretes;

import java.util.ArrayList;
import java.util.List;

import com.example.northwind.core.utilities.logging.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.northwind.bussines.absracts.ProductService;
import com.example.northwind.bussines.request.create.CreateProductsRequest;
import com.example.northwind.bussines.request.update.UpdateProductRequest;
import com.example.northwind.bussines.response.GetAllProductsResponse;
import com.example.northwind.core.utilities.control.ControlService;
import com.example.northwind.core.utilities.mappers.ModelMapperService;
import com.example.northwind.core.utilities.result.DataResult;
import com.example.northwind.core.utilities.result.ErrorDataResult;
import com.example.northwind.core.utilities.result.Result;
import com.example.northwind.core.utilities.result.SuccessDataResult;
import com.example.northwind.core.utilities.result.SuccessResult;
import com.example.northwind.dataAccess.absracts.ProductDao;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategory;

@Service
public class ProductManager implements ProductService {
	ControlService controlService;
	ProductDao productDao;
	ModelMapperService modelMapperService;
	List<Loggers> loggerss;

	@Autowired
	public ProductManager(ProductDao productDao, ModelMapperService modelMapperService,
                          ControlService controlService, List<Loggers> loggerss) {
		super();
		this.productDao = productDao;
		this.modelMapperService = modelMapperService;
		this.controlService = controlService;
		this.loggerss = loggerss;
		}
	@Override
	public DataResult<List<Product>> getAll() {
		try {
			loggerss.forEach(logger -> logger.add("Tüm Ürünler Getirildi"));
			return new SuccessDataResult<List<Product>>
					(this.productDao.findAll(), "Tüm Ürünler Getirildi."  );
		}catch (Exception e){
			loggerss.forEach(logger -> logger.add("Ürünler Getirilemedi," + e.toString()));
			return new ErrorDataResult<List<Product>>(e.toString());
		}
	}
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

	@Override
	public DataResult<List<Product>> findByProductNameOrderByProductNameDesc(String productName) {
		return new SuccessDataResult<List<Product>>(
				this.productDao.findByProductNameOrderByProductNameDesc(productName), "Sondan sıralama gerçekleştirildi"
				);
	}
	
	//Update
	@Override
	public DataResult<Product> update(Product product) {
		Product newProduct = this.productDao.findById(product.getId()).orElseThrow(); 
		newProduct.setProductName("A xxx 1461");
		return new SuccessDataResult<Product> (
				this.productDao.save(newProduct), "güncelleme yapıldı"
				);
	}

	@Override
	public DataResult<List<GetAllProductsResponse>> getAll2() {
		List<Product> product = this.productDao.findAll();
		List<GetAllProductsResponse> allProductsResponses= new ArrayList<GetAllProductsResponse>();
		
		for (Product p : product) {
			GetAllProductsResponse responseItem = new GetAllProductsResponse();
			responseItem.setName(p.getProductName());
			responseItem.setUnitsInStock(p.getUnitsInStock());
			allProductsResponses.add(responseItem);
		}
		
		return new SuccessDataResult<List<GetAllProductsResponse>> (allProductsResponses,"mapper uygulandı.");
	}

	@Override
	public DataResult<CreateProductsRequest> add2(CreateProductsRequest createProductsRequest) {
		try {
			if (this.controlService.productControl(createProductsRequest)) {
				Product product = this.modelMapperService.forRequest().map(createProductsRequest, Product.class);
				this.productDao.save(product);
				return new SuccessDataResult<CreateProductsRequest> ( createProductsRequest, "manuel mapper ile ürün eklendi");
			} else {
				return new ErrorDataResult<CreateProductsRequest> (createProductsRequest,"Aynı isimden ürün eklenemez!!!");
			}
		} catch (Exception e) {
			return new ErrorDataResult<CreateProductsRequest> (e.toString());
		}
		
	}

	@Override
	public DataResult<UpdateProductRequest> update2(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productDao.save(product);
		return new SuccessDataResult<UpdateProductRequest> (updateProductRequest, "update otomatik mapper uygulandı.");
		
	}
}
