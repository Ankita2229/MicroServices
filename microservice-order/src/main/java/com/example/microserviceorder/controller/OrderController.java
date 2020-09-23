package com.example.microserviceorder.controller;

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

import com.example.microserviceorder.dao.OrderDao;
import com.example.microserviceorder.entity.*;
import com.example.microserviceorder.service.OrderService;

@RestController
@RequestMapping("/orders")

public class OrderController {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)              
	public ResponseEntity<?> saveOrder(@RequestBody OrderEntity order) {
		return new ResponseEntity<>(orderDao.save(order),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)              
	public ResponseEntity<?> getItemById(@PathVariable(required = true) Long id) {
		orderService.findById(id);
		return new ResponseEntity<OrderEntity>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
	public List<OrderEntity> getAllOrders(){
		System.out.println(orderService.findAll());
		return orderService.findAll();
	}
	
	@RequestMapping(value = "/updateOrder/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> UpdateOrderDetails(
			 @PathVariable(required = true) Long id,
			 @RequestParam(value="order_status", required = true) String order_status){
		OrderEntity existingOrder = this.orderService.findById(id).orElseThrow(() -> new EntityNotFoundException());
		BeanUtils.copyProperties(order_status, existingOrder);		
		existingOrder.setId(id);		
		this.orderService.AddProduct(existingOrder);		
		return new ResponseEntity<>(existingOrder,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
		this.orderService.delete(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

}