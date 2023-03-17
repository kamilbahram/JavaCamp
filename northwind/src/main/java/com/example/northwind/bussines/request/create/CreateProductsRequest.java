package com.example.northwind.bussines.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductsRequest {
	@Size(min = 6, message = " Üzgünüm , Min 6 karakter olmalı")
	@NotBlank
	private String productName;
	@NotBlank
	private String quantityPerUnit;
}
