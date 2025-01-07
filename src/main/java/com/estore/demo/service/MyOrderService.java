package com.estore.demo.service;

import java.util.List;
import java.util.Optional;

import com.estore.demo.model.MyOrder;

public interface MyOrderService {

	List<MyOrder> getAll();
	
	Optional<MyOrder> getById(int id);
	
	MyOrder Create(MyOrder myorder);
	
	void deleteById(int id);
}
