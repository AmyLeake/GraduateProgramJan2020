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
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="inv_Customers")
public class Customer {

	int customerId;
	
	@FormParam("customerName")
	String customerName;
	
	@FormParam("address")
	String address;
	
	@FormParam("dateOfBirth")
	String dateOfBirth;
	
	//constructor
	public Customer() {
		
	}
	
	Set<Order> orderRecords= new HashSet<>();
	
	//Relationships
	
	//Customer and Order

	@OneToMany(mappedBy="customerOrder", cascade=CascadeType.ALL)
	@XmlTransient
	public Set<Order> getOrderRecords() {
		return orderRecords;
	}
	
	public void setOrderRecords(Set<Order> orderRecords) {
		this.orderRecords = orderRecords;
	}

	
	
	//GETTERS AND SETTERS
	@Id
	@Column(name="customerId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getcustomerId() {
		return customerId;
	}


	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Column(name="customerName", length=50, nullable=false)
	public String getcustomerName() {
		return customerName;
	}


	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getdateOfBirth() {
		return dateOfBirth;
	}


	public void setdateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	//TOSTRING
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	//HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
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
		if (customerId != other.customerId)
			return false;
		return true;
	}
}

