package com.estore.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.demo.model.MyOrder;
import com.estore.demo.repository.MyOrderRepository;
import com.estore.demo.service.MyOrderService;

@Service
public class MyOrderServiceImpl implements MyOrderService{

		@Autowired
		private MyOrderRepository myorderrepository;

		@Override
		public List<MyOrder> getAll() {
			return myorderrepository.findAll();
		}

		@Override
		public Optional<MyOrder> getById(int id) {
			return myorderrepository.findById(id);
		}

		@Override
		public MyOrder Create(MyOrder myorder) {
			return myorderrepository.save(myorder);
		}

		@Override
		public void deleteById(int id) {
			myorderrepository.deleteById(id);
		}

		


}
