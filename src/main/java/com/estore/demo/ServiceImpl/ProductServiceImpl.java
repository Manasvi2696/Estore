package com.estore.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.demo.model.Product;
import com.estore.demo.model.ProductDTO;
import com.estore.demo.repository.ProductRepository;
import com.estore.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public List<Product> getAll() {
		return productrepository.findAll();
	}

	@Override
	public Optional<Product> getById(int id) {
		return productrepository.findById(id);
	}

	@Override
	public Product create(Product product) {
		return productrepository.save(product);
	}

	@Override
	public void deleteById(int id) {
		productrepository.deleteById(id);
	}

	@Override
	public List<Product> findByPriceGreaterThan(Double price) {
		return productrepository.findByPriceGreaterThan(price);
	}

	@Override
	public List<ProductDTO> findExpensiveInStockProducts(Double price) {
		return productrepository.findExpensiveInStockProducts(price);
	}

	

}
