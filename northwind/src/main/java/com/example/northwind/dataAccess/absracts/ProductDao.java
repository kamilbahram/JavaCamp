package com.example.northwind.dataAccess.absracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategory;

public interface ProductDao extends JpaRepository<Product, Integer> , CrudRepository<Product, Integer> {
	Product getByProductName(String productName);
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartsWith(String productName);
	List<Product> findByProductNameOrderByProductNameDesc(String productName);
	
	// select * from Product where productName = "bisey" and productId = "bisey"
	// @Query yapısının örnek sorgusu
	//@Query("From Product where productName=:productName and category =:categoryId")
	//List<Product> getByNameAndCategory(String productName, int categoryId);
	
	
	//inner join 
	//​select p.product_id,p.product_name, c.category_name,p.unit_price 
	// from products p inner join categories c on p.category_id =c.category_id
	@Query("Select new com.example.northwind.entities.dtos.ProductWithCategory" + 
	"(p.id, p.productName, c.categoryName)" + 
	"From Category c Inner Join c.products p")
	List<ProductWithCategory> getProductWithCategoryDetails();

}
 