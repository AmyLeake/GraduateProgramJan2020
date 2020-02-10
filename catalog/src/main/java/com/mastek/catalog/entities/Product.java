package com.mastek.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {

	int product_Id;
	String product_name;
	String description;
	double price;
	int quantity_in_stock;
	
	public Product() {
		
	}
	
	//Getters and Setters
	@Id
	@Column(name="Product_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProduct_Id() {
		return product_Id;
	}
	
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	
	@Column(name="Product_Name", length=50, nullable=false)
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}
	
	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Product [product_Id=" + product_Id + ", product_name=" + product_name + ", description=" + description
				+ ", price=" + price + ", quantity_in_stock=" + quantity_in_stock + "]";
	}
	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + product_Id;
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
		Product other = (Product) obj;
		if (product_Id != other.product_Id)
			return false;
		return true;
	}
}





