package com.npci.springbootloanApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_application_table")
public class LoanApplicationTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int application_id;
	
	//a foreign key reference property
	@Column(name="customer_id_ref")
	private int customer_id;
	
	//a foreign key reference property
	@Column(name="loan_id_ref")
	private int loan_id;
		
	private String status;
	
	
	public LoanApplicationTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanApplicationTable(int application_id, int customer_id, int loan_id, String status) {
		super();
		this.application_id = application_id;
		this.customer_id = customer_id;
		this.loan_id = loan_id;
		this.status = status;
	}
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoanApplicationTable [application_id=" + application_id + ", customer_id=" + customer_id + ", loan_id="
				+ loan_id + ", status=" + status + "]";
	}
}
