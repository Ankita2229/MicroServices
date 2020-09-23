package com.example.microserviceorder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microserviceorder.entity.OrderEntity;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity,Long>{
	
}
