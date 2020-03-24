package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Location;
import com.mastek.hrapp.entities.Payment;
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
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	JobPositionsDAO jobDAO;
	///////////////////////////////////////////////
	

	
	@Test
	void testCashPaymentAdd() {
		Payment cashP = new Payment();
		cashP.setAmount(100);
		
		cashP = paymentDAO.save(cashP);
		
		System.out.println(cashP);
		assertNotNull(cashP,"Cash Payment Not Saved");
	}
	
	
	@Test
	void testCardPaymentAdd() {
		CardPayment cardP = new CardPayment();
		cardP.setAmount(2300);
		cardP.setCardNumber(112233445599l);
		cardP.setCardService("VISA");
		
		cardP = paymentDAO.save(cardP);
		System.out.println(cardP);
		assertNotNull(cardP, "Card Payment Not Saved");
		
	}
	
	@Test
	void testChequePaymentAdd() {
		ChequePayment cheqP = new ChequePayment();
		cheqP.setAmount(444);
		cheqP.setBankName("RBS");
		cheqP.setChequeNumber(223333);
		
		cheqP = paymentDAO.save(cheqP);
		System.out.println(cheqP);
		assertNotNull(cheqP, "Cheque Payment Not Saved");
	}
	
	
	
	
	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}
	
	@Test void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("Employee 13");
		emp.setSalary(1013);
		emp.setDesignation(Designation.DEVELOPER);
		
		emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp, "Employee Not Added");
	}
	
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
	/*@Test
	void testAssignEmployeeToDepartment() {
					// empSVC.assignEmployeeToDepartment(empno,deptno);
		Employee emp = empSvc.assignEmployeeToDepartment(5,10);
		assertNotNull(emp.getCurrentDepartment(),"Department Not Assigned");
		
	}*/
	
	
	
	/*@Test
    void testAssignEmployeeToProject() {            // empno,projectId
        Employee emp = empSvc.assignEmployeeToProject(6,6);
        assertTrue(emp.getProjectsAssigned().size()>0,"Projects assigned");
    }*/

	
	@Test
	void testFindEmployeeBySalary() {
		double minSalary=100;
		double maxSalary=5000;
								//empDAO.findBySalary(minSalary,maxSalary)
		Iterable<Employee>emps=empDAO.findBySalary(minSalary, maxSalary);
		System.out.println("All employee having a salary between "+minSalary+" and "+maxSalary);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	
	@Test
	void testFindEmployeeByDesignation() {
		Iterable<Employee> emps = empDAO.findByDesignation(Designation.ARCHITECT);
		System.out.println("All employees with Designation as "+Designation.ARCHITECT);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testAddJobPositionDocument() {
		JobPositions jp = new JobPositions();
		jp.setJobId(125);
		jp.setLocation("Sheffield");
		jp.setClientName("NHS");
		jp.setSkillSetRequired("Java");
		jp.setNumberOfPositions(5);
		
		jp = jobDAO.save(jp);
		
		assertNotNull(jp, "Job Position Saved");
			
	}
	
	
	@Test
	void testListAllJobPositions() {
		Iterable<JobPositions> jp = jobDAO.findAll();
		assertNotNull(jp, "Jobs not found");
		for (JobPositions job : jp) {
			System.out.println(job);
		}
	}
	

	/*@Test
	void testApplyForJobPositions() {
		int jobId=122;
		int empno=3;
		JobPositions jp = empSvc.applyForJobPositions(jobId,empno);
		
		assertNotNull(jp, "Job not applied");
		System.out.println("Applications for JOB ID: "+jobId);
		for (Employee applicant : jp.getApplicants() ) {
			System.out.println(applicant);
		}
	}*/
	
	
}

















