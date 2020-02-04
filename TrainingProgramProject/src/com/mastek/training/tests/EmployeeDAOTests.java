package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.dao.DataAccessObject;
import com.mastek.training.hrapp.dao.EmployeeBinaryFileDAO;
import com.mastek.training.hrapp.dao.EmployeeJSONFileDAO;

class EmployeeDAOTests {
	
	DataAccessObject<Employee> empDAO;

	@BeforeEach
	void setUp() throws Exception {
		//empDAO = new EmployeeBinaryFileDAO("empdata.dat");
		empDAO = new EmployeeJSONFileDAO("empdata.json");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEmployeeData() {
		Employee newEmp = new Employee();
		newEmp.setEmpno(123);
		newEmp.setName("Example");
		newEmp.setDesignation(Designations.DEVELOPER);
		newEmp.setGrade(Grades.G6);
		newEmp.setUnitDaySalary(233);
		
		String jsonOBJ = Employee.getJSONString(newEmp);
		System.out.println(jsonOBJ);
		Employee exemp = Employee.parseJSONString(jsonOBJ);
		System.out.println(exemp);
		
		
		newEmp = empDAO.add(newEmp); //returns the object if saved successfully 
		assertNotNull(newEmp,"Employee Not Added");
		
		Employee fetchEmp = empDAO.find(123);
		assertNotNull(fetchEmp, "Employee Not Found");
	}
	
	@Test
	void testListAllEmployees() {
		Collection<Employee> emps= empDAO.listAll();
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

	
	@Test
	void testRemoveEmployee() {
		Employee newEmp = new Employee();
		newEmp.setEmpno(9999);
		newEmp.setName("Remove Sample");
		newEmp.setDesignation(Designations.DEVELOPER);
		newEmp.setGrade(Grades.G6);
		newEmp.setUnitDaySalary(233);
		
		newEmp = empDAO.add(newEmp); //returns the object if saved successfully 
		assertNotNull(newEmp,"Employee Not Added");
		
		Employee removedEmp = empDAO.remove(9999);
		assertNotNull(removedEmp, "Employee Not Removed");
		
		Employee checkRemovedEmp = empDAO.find(9999);
		assertNull(checkRemovedEmp, "Employee Not Removed");
	}
	
	
	
	
	
}
