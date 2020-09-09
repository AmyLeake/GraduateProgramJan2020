package com.mastek.farm2home.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="Farmers")
@EntityListeners({EntityListeners.class})
public class Farmer {
	
	int farmerID;
	String name;
	String address;
	int contactNumber;
	String email;
	
	public Farmer() {

	}

	@Id
	@Column(name="farmer_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getFarmerID() {
		return farmerID;
	}

	public void setFarmerID(int farmerID) {
		this.farmerID = farmerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="contact_number")
	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + farmerID;
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
		Farmer other = (Farmer) obj;
		if (farmerID != other.farmerID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Farmer [farmerID=" + farmerID + ", name=" + name + ", address=" + address + ", contactNumber="
				+ contactNumber + ", email=" + email + "]";
	}
	
	

}
