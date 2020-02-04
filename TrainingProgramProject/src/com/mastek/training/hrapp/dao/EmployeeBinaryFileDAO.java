package com.mastek.training.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.dao.DataAccessObject;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {
	
	Map<Integer, Employee> empMap;
	private String fileName;

	public EmployeeBinaryFileDAO(String fileName) {
		empMap = new HashMap<Integer, Employee>();
		this.fileName = fileName;
		//read all the data from the file and load in collection map
		readMapFromFile();
	}
	
	// read the data from the file and add it to the map shared.
	private void readMapFromFile() {
		//ObjectInputStream: Read Object from Binary FileInputStream
		//FileInoutStream: Read Binary Data from file Objects
		//File: Open or refer to the file using Filename/file path.
		try (ObjectInputStream objIn = new ObjectInputStream(
								new FileInputStream(new File(fileName)))){
			//we use try block with resources to manage auto-closing of streams.
			empMap = (Map<Integer, Employee>) objIn.readObject();
			
		}catch (Exception e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
		
	}
	
	// update file with the Map Contents
	private void writeMapToFile() {
		//ObjectOutputStream: Write binary Object in serialised format in FileOutputStream
		//FileOutputStream: Write binary Object to files 
		//File: file object will refer to the file to be updated/created if not present.
		try (ObjectOutputStream objOut = new ObjectOutputStream(
											new FileOutputStream(
													new File(fileName)))){
			objOut.writeObject(empMap);//write all the data in serialised format in the file.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Employee add(Employee newEmployee) {
		readMapFromFile();
		if(!empMap.containsKey(newEmployee.getEmpno())) {
		empMap.put(newEmployee.getEmpno(), newEmployee);
		//update the file with new content
		writeMapToFile();
	}
		return newEmployee;
	}
	
	

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile();
		return empMap.values(); //return all the values from the map
	}

	@Override
	public Employee find(int Key) {
		readMapFromFile();
		return empMap.get(Key);
	}

	@Override
	public Employee remove(int key) {
		readMapFromFile();
		
		Employee removedEmp = null;
		if(empMap.containsKey(key)) {
			removedEmp = empMap.remove(key);
			writeMapToFile();
		}
		return removedEmp;
	}

}
