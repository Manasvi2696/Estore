package com.estore.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estore.demo.model.Product;
import com.estore.demo.model.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByPriceGreaterThan(Double price);

	@Query("select new com.estore.demo.model.ProductDTO(p.name, p.price) from Product p where p.price > :price AND p.stock_quantity > 0")
	List<ProductDTO> findExpensiveInStockProducts(@Param("price") Double price);
}
