package com.mastek.catalog.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

@XmlRootElement
@Entity
@Table(name="Orders")
public class Order {
	
	int orderId;
	
	@FormParam("orderDate")
	int orderDate;
	
	@FormParam("totalItemsOrdered")
	int totalItemsOrdered;
	
	@FormParam("subtotal")
	double subtotal;
	
	@FormParam("vat")
	double vat;
	
	@FormParam("orderTotal")
	double orderTotal;
	
	Customer customerOrder;
	
	//Constructor
	public Order() {
		
	}
	
	//Relationships
	
	//Order and Customer
	
	@ManyToOne
	@JoinColumn(name="fk_customer_order")
	@XmlTransient
	public Customer getCustomerOrder() {
		return customerOrder;
	}
	
	public void setCustomerOrder(Customer customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	
	
	//Order and Product
	Set<Product> orderedProducts = new HashSet<>();
	
	@ManyToMany(mappedBy="productsOrdered")
	@XmlTransient
	public Set<Product> getOrderedProducts() {
		return orderedProducts;
	}
	
	public void setOrderedProducts(Set<Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	//Order and Ingredients
	Set<Ingredient> orderedIngredients = new HashSet<>();
	
	@ManyToMany(mappedBy="ingredientOrdered")
	@XmlTransient
	public Set<Ingredient> getOrderedIngredients() {
		return orderedIngredients;
	}
	
	public void setOrderedIngredients(Set<Ingredient> orderedIngredients) {
		this.orderedIngredients = orderedIngredients;
	}
	
	
	//Getters and setters
	@Id
	@Column(name="OrderID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(int orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalItemsOrdered() {
		return totalItemsOrdered;
	}

	public void setTotalItemsOrdered(int totalItemsOrdered) {
		this.totalItemsOrdered = totalItemsOrdered;
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

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	//toString

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalItemsOrdered=" + totalItemsOrdered
				+ ", subtotal=" + subtotal + ", vat=" + vat + ", orderTotal=" + orderTotal + "]";
	}

	//Hashcode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
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
		if (orderId != other.orderId)
			return false;
		return true;
	}
		

}
