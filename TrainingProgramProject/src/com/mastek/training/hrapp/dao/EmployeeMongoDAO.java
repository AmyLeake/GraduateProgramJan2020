package com.mastek.training.hrapp.dao;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mastek.training.hrapp.Employee;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EmployeeMongoDAO implements DataAccessObject<Employee> {

	MongoCollection<Document> empCollection;
	
	public EmployeeMongoDAO() {
		// 1. Connect to MongoClient
		MongoClient client =  MongoClients.create("mongodb://localhost:27017");
		
		// 2. Use the Database for managing collections
		MongoDatabase db = client.getDatabase("graduate_2020_masteknet");
		
		// 3. Get the MongoCollection Object
		empCollection =  db.getCollection("employees");
		
	}
	
	@Override
	public Employee add(Employee newEmployee) {
		empCollection.insertOne(Employee.getEmployeeMongoDocument(newEmployee));
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		List<Employee> emps = new LinkedList<Employee>();
		
		for(Document empDoc: empCollection.find()) {
			Employee emp = Employee.getEmployeeFromMongoDocument(empDoc);
			emps.add(emp);
		}
		return emps;
	}

	@Override
	public Employee find(int key) {
		return Employee.getEmployeeFromMongoDocument(
					empCollection.find(new Document("empno",key)).first());
	}

	@Override
	public Employee remove(int key) {
		Employee removedEmp = Employee.getEmployeeFromMongoDocument(
				empCollection.find(new Document("empno",key)).first());
		if(removedEmp!=null) {
			empCollection.deleteOne(new Document("empno",key));
		}
		return removedEmp;
	}

}
