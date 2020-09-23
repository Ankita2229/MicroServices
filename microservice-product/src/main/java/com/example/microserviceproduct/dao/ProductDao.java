package com.example.microserviceproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microserviceproduct.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Long>{

}
