package com.mastek.hrapp.services;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Project;

@Component //marking the class as bean o be created
@Scope("singleton") //singleton:One object used across test cases, prototype: one object per request. 
public class EmployeeService implements EmployeeAPI{
	
	String exampleProperty;
	
	//Declare all the entity DOAs to perform operations across multiple entities.
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Autowired
	JobPositionsDAO jobsDAO;
	
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}

	@PostConstruct // initialise method of the class
	public void initialService() {
		System.out.println("Employee Service Initialised");
	}
	
	@PreDestroy // Calls before the shutting down of the application
	public void terminateService() {
		System.out.println("Employee Service Terminated");
	}
	
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}
	
	
	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring Example Data Source") //initialise the property with the value simple value. THIS MUST BE DONE ON THE SET METHOD NOT THE GET METHOD ABOVE!!!!!
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set : "+exampleProperty);
		this.exampleProperty = exampleProperty;
	}

	//ASSOCIATING TWO OBJECT TOGETHER!!!!!!!!!!!!!!!!!!!!
	@Transactional// this will keep the session open until the method returns the value
	public Employee assignEmployeeToDepartment(int empno, int deptno) {
		Employee emp = empDAO.findById(empno).get();
		Department dept = deptDAO.findById(deptno).get();
		
		//assign the association between employee and department
		emp.setCurrentDepartment(dept); //assign department to employee
		dept.getTeam().add(emp); //add the employee in the department team.
		
		//Save changes in the database
		empDAO.save(emp);
		deptDAO.save(dept);
		
		return emp; //return the result.
	}
	
	
	@Transactional
	public Employee assignEmployeeToProject(int empno, int projId) {        
	        Employee emp = empDAO.findById(empno).get(); // get employee object
	        Project newProject = projectDAO.findById(projId).get(); // get project object
	       
	        emp.getProjectsAssigned().add(newProject); // assign employee to project
	        empDAO.save(emp); // save employee object
	       
	        return emp; // return employee object
	    }
	
	
	@Transactional
	public JobPositions applyForJobPositions(int jobId,int empno) {
		JobPositions job=jobsDAO.findById(jobId).get();
		Employee emp = empDAO.findById(empno).get();
		//adding employee object in applicants collection.
		job.getApplicants().add(emp);
		
		job = jobsDAO.save(job);
		return job;
	}
	
	//API

	@Override
	public Iterable<Employee> listAllEmployees() {
		System.out.println("Listing ll Employees");
		return empDAO.findAll();
	}

	@Override
	public Employee findByEmpno(int empno) {
		return empDAO.findById(empno).get();
	}

	@Override
	public Employee registerNewEmployee(Employee newEmployee) {
		newEmployee = empDAO.save(newEmployee);
		return newEmployee;
	}
	
	@Override
	@Transactional
	public Set<Project> getEmployeeProjects(int empno) {
		Employee currentEmp = empDAO.findById(empno).get();
		
		//get the dependencies populated within the method transaction
		int count = currentEmp.getProjectsAssigned().size();
		System.out.println(count +" Projects found");
		
		Set<Project> projects = currentEmp.getProjectsAssigned();
		
		return projects;
	}

	@Override
	@Transactional
	public Project registerProjectForEmployee(int empno, Project newProject) {
		newProject = projectDAO.save(newProject);
		assignEmployeeToProject(empno, newProject.getProjectId());
		return newProject;
	}
	

}
