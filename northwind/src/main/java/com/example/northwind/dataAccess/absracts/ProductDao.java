package com.example.northwind.dataAccess.absracts;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
 