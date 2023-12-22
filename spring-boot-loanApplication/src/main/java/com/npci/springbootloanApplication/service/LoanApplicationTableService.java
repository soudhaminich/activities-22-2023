package com.npci.springbootloanApplication.service;

import java.util.List;

import com.npci.springbootloanApplication.entity.LoanApplicationTable;

public interface LoanApplicationTableService {
	LoanApplicationTable insertLoanAppl(LoanApplicationTable loanData);
	LoanApplicationTable getLoanAppBasedOnAppId(int applId);
	List<LoanApplicationTable> fetchAll();
}
