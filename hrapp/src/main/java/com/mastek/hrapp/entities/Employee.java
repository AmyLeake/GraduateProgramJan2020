package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Transient;


@XmlRootElement //declares the element to be transformed to XML/JSON
@Entity // declares the class as Entity , to be managed by tJPA.
@Table(name="JPA_Employees") //declare the table name associated with this class
@EntityListeners({EmployeeListener.class}) //call the appropriate listener event method on lifecycle event.
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary", // declare the query name as the method in DAO.
			query="select e from Employee e where e.salary between :minSalary and :maxSalary")
			//identify the query to fetch employee objects with properties and parameters.
			// all parameters are to be declared using @Param("<name>") in DAO interface.
	
	,
	@NamedQuery(name="Employee.findByDesignation",
		query="select e from Employee e where e.designation=:designation")
		//identify the method in DAO and pass necessary params.
})
public class Employee {

	int empno;
	
	@FormParam("name")
	String name;
	
	@FormParam("salary")
	double salary;
	
	@FormParam("designation")
	Designation designation;
	
	Department currentDepartment;
	
	
	
	@ManyToOne//one employee is associated with one of many departments
	@JoinColumn(name="fk_department_number") // the foreign key column to store the associated deptno.
	@Transient //ignore this property when storing employee data in MongoDB used for many to many, many to one and one to many
	@XmlTransient //ignore the association when shared via Service
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}
	
	
	Set<Project> projectsAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL) //configure many to many association for entities
	@JoinTable(name="JPA_PROJECT_ASSIGNMENTS",
				joinColumns= {@JoinColumn(name="fk_empno")},
				inverseJoinColumns = {@JoinColumn(name="fk_projectId")}
				)
	@Transient //ignore this property when storing employee data in MongoDB
	@XmlTransient //ignore the association when shared via Service
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}
	
	

	//when creating an entity we must have a constructor
	public Employee() {
		
	}	
	
	@Id //marking the property as primary key.
	@Column(name="employee_number") //using column to provide the default column name 
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto numbering configuration as per DB.
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	// THIS IS THE GET METHOD
	@Column(name="employee_name", length=50, nullable=false) //always on the GET METHOD... not SET METHOD.
	public String getName() {
		return name;
	}

	// THIS IS THE SET METHOD 
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
}


//@Transient : to mark the property get method not to be stored in DB table.