//CHILD CLASS
package com.mastek.hrapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_TABLE_PER_CLASS_CARD_PAYMENT")
public class CardPayment extends Payment {

	long cardNumber;
	String cardService;
	
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardService() {
		return cardService;
	}
	public void setCardService(String cardService) {
		this.cardService = cardService;
	}
	
	//for child class use inherited fields
	@Override
	public String toString() {
		return "CardPayment [cardNumber=" + cardNumber + ", cardService=" + cardService + ", paymentId=" + paymentId
				+ ", amount=" + amount + "]";
	}
	
	
	
	
}
