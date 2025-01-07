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
import org.springframework.web.bind.annotation.RestController;

import com.estore.demo.model.MyOrder;
import com.estore.demo.service.MyOrderService;

@RestController
@RequestMapping("/Myorder")
public class MyOrderController {
	
	@Autowired
	private MyOrderService myOrderService;
	
	@GetMapping("/all")
	public List<MyOrder> getMyOrders(){
		return myOrderService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<MyOrder> getMyOrdersById(@PathVariable int id){
		Optional<MyOrder> myorder = myOrderService.getById(id);
		if(myorder.isPresent()) {
			return ResponseEntity.ok(myorder.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create")
	public MyOrder CreateOrder(@RequestBody MyOrder myorder) {
		return myOrderService.Create(myorder);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteOrdersById(@PathVariable int id){
		Optional<MyOrder> myorder = myOrderService.getById(id);
		if(myorder.isPresent()) {
			myOrderService.deleteById(id);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
