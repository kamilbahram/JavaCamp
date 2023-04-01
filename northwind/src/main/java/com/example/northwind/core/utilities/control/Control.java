package com.example.northwind.core.utilities.control;

import java.util.ArrayList;
import java.util.List;

import com.example.northwind.dataAccess.absracts.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.bussines.request.create.CreateProductsRequest;
import com.example.northwind.entities.concretes.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Control  implements ControlService{
	private static final Logger logger = LoggerFactory.getLogger(Control.class);
	ProductDao productDao;
	@Autowired
	public Control(ProductDao productDao) {
		this.productDao = productDao;
	}

	boolean a;
	public boolean productControl(CreateProductsRequest createProductsRequest) {
		List<Product> products = this.productDao.findAll();
		boolean t;
		for (Product pro : products) {
			t  = pro.getProductName().contains(createProductsRequest.getProductName());
			if (t){
				a=false;
				logger.info(String.format("////" ), Control.class.getSimpleName());
				break;
			} else{
				a=true;
			}
		}
		return a;
	}
}
