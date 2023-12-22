package com.npci.springbootloanApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.springbootloanApplication.entity.LoanApplicationTable;
import com.npci.springbootloanApplication.service.LoanApplicationTableService;

@RestController
@RequestMapping(path="/api/loan")
@CrossOrigin(origins = "*")
public class LoanApplicationTableController {
	
	@Autowired
	private LoanApplicationTableService loan_app_service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody LoanApplicationTable loan_data){
		return ResponseEntity.status(200).body(loan_app_service.insertLoanAppl(loan_data));
	}
	
	@GetMapping
	public ResponseEntity<Object> getAllApi(){
		return ResponseEntity.status(200).body(loan_app_service.fetchAll());
	}
	
	@GetMapping(path="/app_id/{applId}")
	public ResponseEntity<Object> getByApplId(@PathVariable("applId") int applId){
		return ResponseEntity.status(200).body(loan_app_service.getLoanAppBasedOnAppId(applId));
	}
	
}
