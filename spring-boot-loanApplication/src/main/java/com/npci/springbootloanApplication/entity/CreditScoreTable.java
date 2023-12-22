package com.npci.springbootloanApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="credit_score_table")
public class CreditScoreTable {
	@Id
	private String pan;
	private double score;

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public CreditScoreTable(String pan, double score) {
		super();
		this.pan = pan;
		this.score = score;
	}
	public CreditScoreTable() {

	}

	@Override
	public String toString() {
		return "CreditScoreTable [pan=" + pan + ", score=" + score + "]";
	}
}
