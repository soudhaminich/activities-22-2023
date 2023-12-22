package com.npci.springbootloanApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.springbootloanApplication.entity.CustomerTable;
import com.npci.springbootloanApplication.entity.LoanApplicationTable;

public interface LoanApplicationTableRepository extends JpaRepository<LoanApplicationTable, Integer>{
	
	
	@Query("select p from LoanApplicationTable p where p.application_id=?1")
	public LoanApplicationTable getByAppId(int cust_id_ref); 
}
