package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Location;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest // best practise to put the @annotation on the line before the class which it is applied to. 
class HrappApplicationTests {
	
	//THESE ARE JUST EXAMPLES EMPLOYEESERVICE THINGS
	@Autowired // Spring will provide the object using IOC, dependency Injection Technique.
	EmployeeService empSvc;

	@Autowired
	EmployeeService empSvc1;
	/////////////////////////////////////////////
	
	//MUST ADD THESE IN FOR THE NEW INTERFACES
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	///////////////////////////////////////////////
	
	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}
	
/*	@Test void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("Employee 13");
		emp.setSalary(1013);
		emp.setDesignation(Designation.DEVELOPER);
		
		emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp, "Employee Not Added");
	}*/
	
	@Test
	void testListEmployees() {
		Iterable<Employee> emps = empDAO.findAll();
		assertNotNull(emps, "Employees not Found");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	
/*	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee Fetched: "+emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		emp = empDAO.save(emp);
		
		System.out.println("Updated Empoyees: "+emp);
	}
	
	
	@Test
	void testDeleteEmployeesById() {
		//empDAO.delete(emp); // this can be used if we know which whole entity we want to delete. DELETES BY OBJECT.
		empDAO.deleteById(30); //DELETES BY ID.
		
	}
	
	
	@Test
	void testDepartmentDAOAdd() {
		Department dept = new Department();
		dept.setName("Legal");
		dept.setLocation(Location.LONDON);
		 
		dept = deptDAO.save(dept);
		
		assertNotNull(dept, "Department Not Added");
	}

	@Test
	void testProjectDAOAdd() {
		Project project = new Project();
		project.setName("A");
		project.setCustomerName("CBI");
		
		project = projectDAO.save(project);
		assertNotNull(project, "Project Not Added");
	}
	
	*/
	@Test
	void testAssignEmployeeToDepartment() {
					// empSVC.assignEmployeeToDepartment(empno,deptno);
		Employee emp = empSvc.assignEmployeeToDepartment(5,10);
		assertNotNull(emp.getCurrentDepartment(),"Department Not Assigned");
		
	}
	
	
	
	//New test from Jack
	
	@Test
    void testAssignEmployeeToProject() {            // empno,projectId
        Employee emp = empSvc.assignEmployeeToProject(6,6);
        assertTrue(emp.getProjectsAssigned().size()>0,"Projects assigned");
    }

}

















