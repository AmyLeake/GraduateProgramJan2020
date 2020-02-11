//BASE CLASS
package com.mastek.hrapp.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity //DECLARE AS AN ENTITY
@Table(name="JPA_TABLE_PER_CLASS_PAYMENT") //DEFINE THE TABLE
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //CHOOSE SINGLE TABLE
public class Payment {
	
	int paymentId;
	double amount;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paymentId;
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
		Payment other = (Payment) obj;
		if (paymentId != other.paymentId)
			return false;
		return true;
	}
	

}
