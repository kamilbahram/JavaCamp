package com.example.northwind.entities.concretes;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                           //set ve get metotlarını oluşturuyor.
@AllArgsConstructor            //Constructor ları oluşturuyor
@NoArgsConstructor            //Parametresiz constructor ları oluşturuyor
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "product_id")
	private int id;
	//İlişkilendirme yapıldığı için category_id commentlendi
	//@Column(name = "category_id")
	//private int catagoryId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private short unitsInStock;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	//, insertable = false, updatable = false
	
	
	
}