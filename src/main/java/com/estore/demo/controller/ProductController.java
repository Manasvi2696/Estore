package com.estore.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estore.demo.model.Product;
import com.estore.demo.model.ProductDTO;
import com.estore.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	private static final Logger logger = LogManager.getLogger(ProductController.class);

	@GetMapping("/allproducts")
	public List<Product> getProducts(){
		logger.info("Fatching All Products...");
		return productservice.getAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Optional<Product> product = productservice.getById(id);
		if(product.isPresent()) {
			logger.info("Fatching Product with id : "+id);
			return ResponseEntity.ok(product.get());
		}else {
			logger.info("Product with id : "+id+" is not found");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		logger.info("Creating new Product...");
		return productservice.create(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable int id){
		Optional<Product> product = productservice.getById(id);
		logger.info("Deleting Product with id:"+id);
		if(product.isPresent()) {
			productservice.deleteById(id);
			logger.info("Product with id : "+id+" deleted");
			return ResponseEntity.noContent().build();
		}else {
			logger.info("Product with id : "+id+" not found");
			return ResponseEntity.notFound().build();
		}
	}
	
	
    @GetMapping("/above-price")
    public List<Product> getProductsAbovePrice(@RequestParam Double price) {
        return productservice.findByPriceGreaterThan(price);
    }

   
    @GetMapping("/expensive-in-stock")
    public List<ProductDTO> getExpensiveInStockProducts(@RequestParam Double price) {
        return productservice.findExpensiveInStockProducts(price);
    }
}
