package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//DEPARTMENT CLASS
@Entity
@Table(name="JPA_Department")
public class Department {
	
	int deptno;
	String name;
	Location location;
	
	Set<Employee> team = new HashSet<>();
	//associates the many entity using collection with cascade enabled
	@OneToMany(mappedBy="currentDepartment", cascade=CascadeType.ALL)
	public Set<Employee> getTeam() {
		return team;
	}

	public void setTeam(Set<Employee> team) {
		this.team = team;
	}

	// CONSTRUCTOR
	public Department() {
	
	}

	//GETTERS AND SETTERS
	
	@Id //PRIMARY KEY!!!!!!
	@Column(name="department_number") //DEFAULT COLUMN NAME
	@GeneratedValue(strategy=GenerationType.AUTO) //AUTO GENERATE NUMBER
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Column(name="department_name", length=80, nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//SHOULD THIS BE AN ENUM?? YES?
	@Enumerated(EnumType.STRING)
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	//toStrings's
	
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
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
		Department other = (Department) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}

	
	
}