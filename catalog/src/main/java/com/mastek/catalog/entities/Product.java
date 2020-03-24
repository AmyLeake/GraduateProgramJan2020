package com.mastek.catalog.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

@XmlRootElement
@Entity
@Table(name="Products")
public class Product {

	int productId;
	
	@FormParam("productName")
	String productName;
	
	@FormParam("description")
	String description;
	
	@FormParam("price")
	double price;
	
	@FormParam("quantityInStock")
	int quantityInStock;
	
	Category productCategory;

	//Constructor
	public Product() {
		
	}
	
	//Relationships
	
	//Product and Category
	@ManyToOne
	@JoinColumn(name="fk_categoryNumber")
	@XmlTransient
	public Category getProductCategory() {
		return productCategory;
	}
	
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
		
	//Product and Order
	
	Set<Order> productsOrdered = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_PRODUCTS_ORDERED",
				joinColumns= {@JoinColumn(name="fk_productId")},
				inverseJoinColumns = {@JoinColumn(name="fk_orderId")}
				)
	@XmlTransient
	public Set<Order> getProductsOrdered() {
		return productsOrdered;
	}
	
	public void setProductsOrdered(Set<Order> productsOrdered) {
		this.productsOrdered = productsOrdered;
	}
	
	
	//Getters and Setters
	@Id
	@Column(name="productID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Column(name="Product_Name", length=50, nullable=false)
	public String getProduct_name() {
		return productName;
	}
	
	public void setProduct_name(String product_name) {
		this.productName = product_name;
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
		return quantityInStock;
	}
	
	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantityInStock = quantity_in_stock;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", product_name=" + productName + ", description=" + description
				+ ", price=" + price + ", quantity_in_stock=" + quantityInStock + "]";
	}
	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		if (productId != other.productId)
			return false;
		return true;
	}
}





