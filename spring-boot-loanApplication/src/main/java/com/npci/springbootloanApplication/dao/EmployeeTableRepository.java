package com.npci.springbootloanApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.springbootloanApplication.entity.EmployeeTable;

public interface EmployeeTableRepository extends JpaRepository<EmployeeTable, Integer>{

}
