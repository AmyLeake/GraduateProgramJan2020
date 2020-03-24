package com.mastek.bankservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_transfer_requests")
public class TransferRequest {

	int id;
	int fromAccount;
	int toAccount;
	double amount;
	String description;
	
	@Id	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TransferRequest [id=" + id + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount="
				+ amount + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		TransferRequest other = (TransferRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
