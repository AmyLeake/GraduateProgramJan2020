package com.mastek.bankservice.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="JPA_Customer_Accounts")
public class Account {
	
	int account_number;
	int sort_code;
	ActiveAccount account_type;
	double total;
	
	//One to many relationship with transaction.
	Set<Transaction> team = new HashSet<>();
	@OneToMany(mappedBy="accountTransaction", cascade=CascadeType.ALL)
	public Set<Transaction> getTeam() {
		return team;
	}
	
	public void setTeam(Set<Transaction> team) {
		this.team = team;
	}
	
	//Many to Many relationship with customer
	
	Set<Customer> customerAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_JOINT_ACCOUNT",
				joinColumns= {@JoinColumn(name="fk_account_number")},
				inverseJoinColumns = {@JoinColumn(name="fk_cust_id")}
				)
	@Transient
	public Set<Customer> getCustomerAssigned() {
		return customerAssigned;
	}
	
	public void setCustomerAssigned(Set<Customer> customerAssigned) {
		this.customerAssigned = customerAssigned;
	}
	
	
	
	//Constructor
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	//Getters and Setters
	@Id
	@Column(name="Account_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getAccount_number() {
		return account_number;
	}


	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}


	public int getSort_code() {
		return sort_code;
	}


	public void setSort_code(int sort_code) {
		this.sort_code = sort_code;
	}


	@Enumerated(EnumType.STRING)
	public ActiveAccount getAccount_type() {
		return account_type;
	}


	public void setAccount_type(ActiveAccount account_type) {
		this.account_type = account_type;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	//toString
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", sort_code=" + sort_code + ", account_type="
				+ account_type + ", total=" + total + "]";
	}


	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_number;
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
		Account other = (Account) obj;
		if (account_number != other.account_number)
			return false;
		return true;
	}
	
	

}
