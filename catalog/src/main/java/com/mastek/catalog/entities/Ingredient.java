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
@Table(name="Ingredients")
public class Ingredient {

	int ingredientId;
	
	@FormParam("ingredientName")
	String ingredientName;
	
	@FormParam("quantityInStock")
	int quantityInStock;
	
	Category ingredientCategory;
		
	//Constructor
	public Ingredient() {
		
	}
	
	//Relationships
	
	//Ingredient and Order
	
	Set<Order> ingredientOrdered = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_INGREDIENTS_ORDERED",
				joinColumns= {@JoinColumn(name="fk_ingredientId")},
				inverseJoinColumns = {@JoinColumn(name="fk_orderId")}
				)
	@Transient
	@XmlTransient
	public Set<Order> getIngredientOrdered() {
		return ingredientOrdered;
	}
	
	public void setIngredientOrdered(Set<Order> ingredientOrdered) {
		this.ingredientOrdered = ingredientOrdered;
	}
	
	//Ingredient and Category
	
	@ManyToOne
	@JoinColumn(name="fk_categoryId")
	@Transient
	@XmlTransient
	public Category getIngredientCategory() {
		return ingredientCategory;
	}
	
	public void setIngredientCategory(Category ingredientCategory) {
		this.ingredientCategory = ingredientCategory;
	}
		
	
	//Getters and Setters	
	
	@Id
	@Column(name="ingredientId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredient_name() {
		return ingredientName;
	}

	public void setIngredient_name(String ingredient_name) {
		this.ingredientName = ingredient_name;
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
		return "Ingredient [ingredient_Id=" + ingredientId + ", ingredient_name=" + ingredientName
				+ ", quantity_in_stock=" + quantityInStock + ", ingredientOrdered=" + ingredientOrdered + "]";
	}

	//HashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
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
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId)
			return false;
		return true;
	}

	

	

	


	
		
	
}
