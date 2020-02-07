package com.mastek.catalog.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {

	int customer_id;
	String customer_name;
	String address;
	String date_of_birth;
}
