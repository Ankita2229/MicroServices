package com.example.microservicecustomer.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservicecustomer.dao.CustomerDao;
import com.example.microservicecustomer.entity.CustomerEntity;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	@Transactional
	public CustomerEntity AddCustomer(CustomerEntity product){
		return customerDao.save(product);
	}
	
	@Transactional
    public Optional<CustomerEntity> findById(Long id) {
        return customerDao.findById(id);
    }

	public List<CustomerEntity> findAll() {
		return customerDao.findAll();
	}

	public void delete(Long id) {
		customerDao.deleteById(id);
	}
}
