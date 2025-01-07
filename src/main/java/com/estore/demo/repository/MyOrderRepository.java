package com.estore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estore.demo.model.MyOrder;

@Repository
public interface MyOrderRepository extends JpaRepository<MyOrder, Integer>{

}
