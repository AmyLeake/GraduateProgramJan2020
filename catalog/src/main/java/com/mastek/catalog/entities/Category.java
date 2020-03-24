package com.mastek.catalog.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;

@XmlRootElement
@Entity
@Table(name="Categories")
public class Category {

	int categoryId;
	
	@FormParam("categoryName")
	CategoryName categoryName;
	
	@FormParam("description")
	String description;
	
	@FormParam("totalItems")
	int totalItems;
		
	
	//Constructor
	public Category() {
		
	}
	
	//Relationships
	
	//Category and product
	Set<Product> currentCategory = new HashSet<>();
	
	@Transient
	@XmlTransient
	@OneToMany(mappedBy="productCategory", cascade=CascadeType.ALL)
	public Set<Product> getCurrentCategory() {
		return currentCategory;
	}
	
	public void setCurrentCategory(Set<Product> currentCategory) {
		this.currentCategory = currentCategory;
	}
	
	//Category and Ingredient
	Set<Ingredient> currentIngredient = new HashSet<>();
	
	@Transient
	@XmlTransient
	@OneToMany(mappedBy="ingredientCategory", cascade=CascadeType.ALL)
	public Set<Ingredient> getCurrentIngredient() {
		return currentIngredient;
	}
	
	public void setCurrentIngredient(Set<Ingredient> currentIngredient) {
		this.currentIngredient = currentIngredient;
	}
	
	
	//Getters and Setters
	@Id
	@Column(name="Category_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCategory_Id() {
		return categoryId;
	}

	public void setCategory_Id(int category_Id) {
		categoryId = category_Id;
	}

	@Enumerated(EnumType.STRING)
	public CategoryName getCategory_name() {
		return categoryName;
	}

	public void setCategory_name(CategoryName category_name) {
		this.categoryName = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal_items() {
		return totalItems;
	}

	public void setTotal_items(int total_items) {
		this.totalItems = total_items;
	}

	//toString
	@Override
	public String toString() {
		return "Category [Category_Id=" + categoryId + ", Category_name=" + categoryName + ", Description="
				+ description + ", total_items=" + totalItems + "]";
	}

	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}
}
