package com.example.northwind.bussines.request.update;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String quantityPerUnit;

}
