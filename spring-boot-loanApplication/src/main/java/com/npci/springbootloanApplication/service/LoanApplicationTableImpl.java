package com.npci.springbootloanApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.springbootloanApplication.dao.LoanApplicationTableRepository;
import com.npci.springbootloanApplication.entity.LoanApplicationTable;

@Service
public class LoanApplicationTableImpl implements LoanApplicationTableService{

	@Autowired
	private LoanApplicationTableRepository loan_app_dao;
	
	@Override
	public LoanApplicationTable insertLoanAppl(LoanApplicationTable loanData) {
		return (loan_app_dao.save(loanData));
	}

	@Override
	public LoanApplicationTable getLoanAppBasedOnAppId(int applId) {
		LoanApplicationTable loan_data=loan_app_dao.getByAppId(applId);
		return loan_data;
	}

	@Override
	public List<LoanApplicationTable> fetchAll() {
		List<LoanApplicationTable> loan_list=loan_app_dao.findAll();
		return loan_list;
	}
	
}
