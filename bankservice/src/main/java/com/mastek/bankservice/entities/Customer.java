package com.mastek.bankservice.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Customers")
@EntityListeners({CustomerListener.class})
public class Customer {

	int cust_id;
	String first_name;
	String surname;
	String address;
	String town;
	String city;
	String pcode;
	int number_of_accounts;
	
	//Many to many relationship with Account.
	Set<Account> customerAccount = new HashSet<>();
	
	@ManyToMany(mappedBy="customerAssigned")
	public Set<Account> getCustomerAccount() {
		return customerAccount;
	}
	
	public void setCustomerAccount(Set<Account> customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	
	
	
	//Constructor
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters	
	@Id //Primary Key
	@Column(name="Customer_Id")
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto Numbering
	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	
	@Column(name="First_name", length=15, nullable=false)
	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	@Column(name="Surname", length=20, nullable=false)
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTown() {
		return town;
	}


	public void setTown(String town) {
		this.town = town;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPcode() {
		return pcode;
	}


	public void setPcode(String pcode) {
		this.pcode = pcode;
	}


	public int getNumber_of_accounts() {
		return number_of_accounts;
	}


	public void setNumber_of_accounts(int number_of_accounts) {
		this.number_of_accounts = number_of_accounts;
	}

	
	
	//toString
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", first_name=" + first_name + ", surname=" + surname + ", address="
				+ address + ", town=" + town + ", city=" + city + ", pcode=" + pcode + ", number_of_accounts="
				+ number_of_accounts + "]";
	}

	//HasCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cust_id;
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
		Customer other = (Customer) obj;
		if (cust_id != other.cust_id)
			return false;
		return true;
	}


}
