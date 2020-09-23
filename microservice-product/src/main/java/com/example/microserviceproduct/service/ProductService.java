package com.example.microserviceproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microserviceproduct.dao.ProductDao;
import com.example.microserviceproduct.entity.ProductEntity;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Transactional
	public ProductEntity AddProduct(ProductEntity product){
		return productDao.save(product);
	}
	
	@Transactional
    public Optional<ProductEntity> findById(Long id) {
        return productDao.findById(id);
    }

	public List<ProductEntity> findAll() {
		return productDao.findAll();
	}

	public void delete(Long id) {
		productDao.deleteById(id);
	}
}
