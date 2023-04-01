package com.example.northwind.core.utilities.control;

import com.example.northwind.bussines.request.create.CreateProductsRequest;

public interface ControlService {
	public boolean productControl(CreateProductsRequest createProductsRequest);
}
