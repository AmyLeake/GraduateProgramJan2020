package com.mastek.bankservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="JPA_Customer_Transactions")
public class Transaction {

	int transaction_id;
	String transaction_date;
	int account_from;
	int account_to;
	String description;
	double transaction_total;
	
	Account accountTransaction;
	
	//Many to one relationship with account
	@ManyToOne
	@JoinColumn(name="fk_account_number")
	@Transient
	public Account getAccountTransaction() {
		return accountTransaction;
	}
	
	public void setAccountTransaction(Account accountTransaction) {
		this.accountTransaction = accountTransaction;
	}
	
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	
	//Getters and Setters
	@Id
	@Column(name="Transaction_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public String getTransaction_date() {
		return transaction_date;
	}


	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}


	public int getAccount_from() {
		return account_from;
	}


	public void setAccount_from(int account_from) {
		this.account_from = account_from;
	}


	public int getAccount_to() {
		return account_to;
	}


	public void setAccount_to(int account_to) {
		this.account_to = account_to;
	}

	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getTransaction_total() {
		return transaction_total;
	}


	public void setTransaction_total(double transaction_total) {
		this.transaction_total = transaction_total;
	}


	//toString
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", transaction_date=" + transaction_date
				+ ", account_from=" + account_from + ", account_to=" + account_to + ", description=" + description
				+ ", transaction_total=" + transaction_total + "]";
	}
	

	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transaction_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transaction_id != other.transaction_id)
			return false;
		return true;
	}
	
	
	
}
