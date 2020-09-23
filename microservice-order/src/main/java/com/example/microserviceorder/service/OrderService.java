package com.example.microserviceorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microserviceorder.dao.OrderDao;
import com.example.microserviceorder.entity.OrderEntity;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public OrderEntity AddProduct(OrderEntity order){
		return orderDao.save(order);
	}
	
	@Transactional
    public Optional<OrderEntity> findById(Long id) {
        return orderDao.findById(id);
    }

	public List<OrderEntity> findAll() {
		return orderDao.findAll();
	}

	public void delete(Long id) {
		orderDao.deleteById(id);
	}
}
