package com.example.microserviceproduct.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceproduct.dao.ProductDao;
import com.example.microserviceproduct.entity.ProductEntity;
import com.example.microserviceproduct.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)              
	public ResponseEntity<?> saveProduct(@RequestBody ProductEntity product) {
		return new ResponseEntity<>(productDao.save(product),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)              
	public ResponseEntity<?> getItemById(@PathVariable(required = true) Long id) {
		productService.findById(id);
		return new ResponseEntity<ProductEntity>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public List<ProductEntity> getAllProducts(){
		System.out.println(productService.findAll());
		return productService.findAll();
	}
	
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> UpdateProductDetails(
			 @PathVariable(required = true) Long id,
			 @RequestParam(value="name", required = false) String name, @RequestParam(value="quantity", required = false) int quantity){
		ProductEntity existingProduct = this.productService.findById(id).orElseThrow(() -> new EntityNotFoundException());
		BeanUtils.copyProperties(name, existingProduct);		
		existingProduct.setId(id);		
		this.productService.AddProduct(existingProduct);		
		return new ResponseEntity<>(existingProduct,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
		this.productService.delete(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
}
