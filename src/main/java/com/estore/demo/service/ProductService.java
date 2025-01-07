package com.estore.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.estore.demo.model.Product;
import com.estore.demo.model.ProductDTO;

public interface ProductService {

	List<Product> getAll();
	
	Optional<Product> getById(int id);
	
	Product create(Product product);
	
	void deleteById(int id);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	List<ProductDTO> findExpensiveInStockProducts(Double price);
}
