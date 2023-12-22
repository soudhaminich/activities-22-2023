package com.npci.springbootloanApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.springbootloanApplication.dao.CreditScoreTableRepository;
import com.npci.springbootloanApplication.dao.CustomerTableRepository;
import com.npci.springbootloanApplication.entity.CreditScoreTable;
import com.npci.springbootloanApplication.entity.CustomerTable;

@Service
public class CustomerTableImpl implements CustomerTableService{
	
	@Autowired
	private CustomerTableRepository cust_dao;
	
	@Autowired
	private CreditScoreTableRepository credit_score_dao;
	
	@Override
	public List<CustomerTable> fetchCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerTable storeCustomers(CustomerTable customer) {
		CustomerTable custData=cust_dao.save(customer);
		CreditScoreTable creditScore= credit_score_dao.save(new CreditScoreTable(custData.getPan(),750.00));
		return custData;
	}

	@Override
	public CustomerTable fetchByCustomerEmail(String cust_email) {
		CustomerTable getCust=cust_dao.getByCustId(cust_email);
		return getCust;
	}

}
