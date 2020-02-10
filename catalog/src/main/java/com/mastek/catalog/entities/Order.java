package com.mastek.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	
	int order_id;
	int order_date;
	String items_ordered;
	int total_items_ordered;
	double subtotal;
	double vat;
	double order_total;
	
	public Order() {
		
	}
	
	//Getters and setters
	@Id
	@Column(name="Order_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getOrder_date() {
		return order_date;
	}
	
	public void setOrder_date(int order_date) {
		this.order_date = order_date;
	}
	
	public String getItems_ordered() {
		return items_ordered;
	}
	
	public void setItems_ordered(String items_ordered) {
		this.items_ordered = items_ordered;
	}
	
	public int getTotal_items_ordered() {
		return total_items_ordered;
	}
	
	public void setTotal_items_ordered(int total_items_ordered) {
		this.total_items_ordered = total_items_ordered;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public double getVat() {
		return vat;
	}
	
	public void setVat(double vat) {
		this.vat = vat;
	}
	
	public double getOrder_total() {
		return order_total;
	}
	
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", items_ordered=" + items_ordered
				+ ", total_items_ordered=" + total_items_ordered + ", subtotal=" + subtotal + ", vat=" + vat
				+ ", order_total=" + order_total + "]";
	}
	
	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order_id;
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
		Order other = (Order) obj;
		if (order_id != other.order_id)
			return false;
		return true;
	}

}
