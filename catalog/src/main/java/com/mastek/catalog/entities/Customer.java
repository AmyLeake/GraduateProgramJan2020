package com.mastek.catalog.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="inv_Customers")
public class Customer {

	int customer_id;
	String customer_name;
	String address;
	String date_of_birth;
	
/*	Set<Order> rel1 = new HashSet<>();
	@OneToMany(mappedBy="customerOrders", cascade=CascadeType.ALL)
	public Set<Order> getRel1() {
		return rel1;
	}*/
	
	//constructor
	public Customer() {
		
	}
	
	//GETTERS AND SETTERS
	@Id
	@Column(name="Customer_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	@Column(name="Customer_Name", length=50, nullable=false)
	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	
	

	//TOSTRING
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", address=" + address
				+ ", date_of_birth=" + date_of_birth + "]";
	}
	
	
	//HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
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
		if (customer_id != other.customer_id)
			return false;
		return true;
	}
}

