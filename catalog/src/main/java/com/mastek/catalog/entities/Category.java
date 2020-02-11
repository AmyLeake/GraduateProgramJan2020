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

@Entity
@Table(name="Categories")
public class Category {

	int Category_Id;
	CategoryName Category_name;
	String Description;
	int total_items;
	
/*	Set<Ingredient> rel2 = new HashSet<>();
	@OneToMany(mappedBy="ingredientCategory", cascade=CascadeType.ALL)
	public Set<Ingredient> getRel2(){
		return rel2;
	}
	
	Set<Product> rel3 = new HashSet<>();
	@OneToMany(mappedBy="productCategory", cascade=CascadeType.ALL)
	public Set<Product> getRel3() {
		return rel3;
	}*/
	
	
	//Constructor
	public Category() {
		
	}
	
	
	//Getters and Setters
	@Id
	@Column(name="Category_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCategory_Id() {
		return Category_Id;
	}

	public void setCategory_Id(int category_Id) {
		Category_Id = category_Id;
	}

	@Enumerated(EnumType.STRING)
	public CategoryName getCategory_name() {
		return Category_name;
	}

	public void setCategory_name(CategoryName category_name) {
		this.Category_name = category_name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getTotal_items() {
		return total_items;
	}

	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}

	//toString
	@Override
	public String toString() {
		return "Category [Category_Id=" + Category_Id + ", Category_name=" + Category_name + ", Description="
				+ Description + ", total_items=" + total_items + "]";
	}

	//HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Category_Id;
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
		if (Category_Id != other.Category_Id)
			return false;
		return true;
	}
}
