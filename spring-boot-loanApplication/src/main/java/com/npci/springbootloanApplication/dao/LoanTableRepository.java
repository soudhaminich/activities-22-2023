package com.npci.springbootloanApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.springbootloanApplication.entity.LoanTable;

public interface LoanTableRepository extends JpaRepository<LoanTable, Integer>{

}
