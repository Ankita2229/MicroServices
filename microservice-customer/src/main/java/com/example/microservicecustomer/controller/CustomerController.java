package com.example.microservicecustomer.controller;

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

import com.example.microservicecustomer.dao.CustomerDao;
import com.example.microservicecustomer.entity.CustomerEntity;
import com.example.microservicecustomer.service.CustomerService;

@RestController
@RequestMapping("/customers")

public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)              
	public ResponseEntity<?> AddCustomer(@RequestBody CustomerEntity customer) {
		return new ResponseEntity<>(customerDao.save(customer),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET)              
	public ResponseEntity<?> getCustomerById(@PathVariable(required = true) Long id) {
		customerService.findById(id);
		return new ResponseEntity<CustomerEntity>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public List<CustomerEntity> getAllCustomers(){
		System.out.println(customerService.findAll());
		return customerService.findAll();
	}
	
	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> UpdateCustomerDetails(
			 @PathVariable(required = true) Long id,
			 @RequestParam(value="firstname", required = true) String firstname, @RequestParam(value="lastname", required = true) String lastname , @RequestParam(value="email", required = true) String email){
		CustomerEntity existingCustomer = this.customerService.findById(id).orElseThrow(() -> new EntityNotFoundException());
		BeanUtils.copyProperties(email, existingCustomer);		
		existingCustomer.setId(id);		
		this.customerService.AddCustomer(existingCustomer);		
		return new ResponseEntity<>(existingCustomer,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
		this.customerService.delete(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
}
