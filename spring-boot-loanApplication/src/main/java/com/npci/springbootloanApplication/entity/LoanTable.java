package com.npci.springbootloanApplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_table")
public class LoanTable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loan_id;

	private String loan_type;

	//this joins profile and contact table by matching primary key=foreign key with the help of @JoinColumn
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="loan_id_ref")
	private List<LoanApplicationTable> loanId_ref;
	
	public LoanTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int load_id) {
		this.loan_id = load_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	@Override
	public String toString() {
		return "LoanTable [load_id=" + loan_id + ", loan_type=" + loan_type + "]";
	}

	public LoanTable(int load_id, String loan_type, List<LoanApplicationTable> loanId_ref) {
		super();
		this.loan_id = load_id;
		this.loan_type = loan_type;
	}
	
	
}	
