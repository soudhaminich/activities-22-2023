package com.npci.springbootloanApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.npci.springbootloanApplication.entity.CustomerTable;

public interface CustomerTableRepository extends JpaRepository<CustomerTable, Integer>{
	@Query("select p from CustomerTable p where p.email_id=?1")
	public CustomerTable getByCustId(String cust_mail); 
}
