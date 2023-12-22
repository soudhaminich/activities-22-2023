package com.npci.springbootloanApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npci.springbootloanApplication.entity.CustomerTable;
import com.npci.springbootloanApplication.service.CustomerTableService;

@RestController
@RequestMapping(path="/api/customer")
@CrossOrigin(origins = "*")
public class CustomerTableController {
	@Autowired
	private CustomerTableService cust_service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody CustomerTable customer){
		//since here there are no exceptions to handle we can directly call profileService.store
		return ResponseEntity.status(201).body(cust_service.storeCustomers(customer));
	}
	
	@GetMapping(path="/getCustomer/{cust_email}")
	public ResponseEntity<Object> getApi(@PathVariable("cust_email") String cust_mail){
		return ResponseEntity.status(200).body(cust_service.fetchByCustomerEmail(cust_mail));
	}
	
}
