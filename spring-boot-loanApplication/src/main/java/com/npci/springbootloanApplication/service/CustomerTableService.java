package com.npci.springbootloanApplication.service;

import java.util.List;
import java.util.Optional;

import com.npci.springbootloanApplication.entity.CustomerTable;

public interface CustomerTableService {
	List<CustomerTable> fetchCustomers();
	CustomerTable storeCustomers(CustomerTable customer);
	CustomerTable fetchByCustomerEmail(String cust_email);
}
