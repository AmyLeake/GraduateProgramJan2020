package com.mastek.catalog.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.catalog.entities.Ingredient;

@Repository
public interface IngredientJPADAO extends 
				CrudRepository<Ingredient, Integer>{

}
