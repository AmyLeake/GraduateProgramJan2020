package com.mastek.catalog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ingredients")
public class Ingredient {

	int ingredient_Id;
	String ingredient_name;
	String description;
	int quantity_in_stock;
	
	public Ingredient() {
		
	}
	
		
	@Id
	@Column(name="Ingredient_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIngredient_Id() {
		return ingredient_Id;
	}


	public void setIngredient_Id(int ingredient_Id) {
		this.ingredient_Id = ingredient_Id;
	}


	@Column(name="Ingredient_Name", length=50, nullable=false)
	public String getIngredient_name() {
		return ingredient_name;
	}


	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}


	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}


	@Override
	public String toString() {
		return "Ingredient [ingredient_Id=" + ingredient_Id + ", ingredient_name=" + ingredient_name + ", description="
				+ description + ", quantity_in_stock=" + quantity_in_stock + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredient_Id;
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
		if (ingredient_Id != other.ingredient_Id)
			return false;
		return true;
	}
	
}
