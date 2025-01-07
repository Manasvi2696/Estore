package com.estore.demo.controller;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/allproducts")
	public List<Product> getProducts(){
		return productservice.getAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Optional<Product> product = productservice.getById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		return productservice.create(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable int id){
		Optional<Product> product = productservice.getById(id);
		
		if(product.isPresent()) {
			productservice.deleteById(id);
			return ResponseEntity.noContent().build();
		}else {
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
