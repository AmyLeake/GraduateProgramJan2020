package com.mastek.bankservice.entities;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import org.springframework.stereotype.Component;

@Component
public class CustomerListener {

	@PrePersist
	public void beforeCustInsert(Customer c) {
		System.out.println("Before Customer Insert");
	}
	
	@PostPersist
	public void afterCustomerInsert(Customer c) {
		System.out.println("After Customer Insert");
		System.out.println("Send welcome email to "+c.getFirst_name()+" "+c.getSurname());
	}
}
