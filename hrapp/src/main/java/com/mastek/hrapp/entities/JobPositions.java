package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_INTERNAL_JOB_POSITIONS")
public class JobPositions {

	int jobId;
	String clientName;
	int numberOfPositions;
	String skillSetRequired;
	String location;
	
	Set<Employee>applicants = new HashSet<>();
		
	public Set<Employee> getApplicants() {
		return applicants;
	}


	public void setApplicants(Set<Employee> applicants) {
		this.applicants = applicants;
	}


	//Constructor
	public JobPositions() {
		// TODO Auto-generated constructor stub
	}
	
		
	//getters and setters
	@Id
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}



	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getNumberOfPositions() {
		return numberOfPositions;
	}


	public void setNumberOfPositions(int numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}


	public String getSkillSetRequired() {
		return skillSetRequired;
	}


	public void setSkillSetRequired(String skillSetRequired) {
		this.skillSetRequired = skillSetRequired;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	//hashcode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jobId;
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
		JobPositions other = (JobPositions) obj;
		if (jobId != other.jobId)
			return false;
		return true;
	}

	//toString
	
	@Override
	public String toString() {
		return "JobPositions [jobId=" + jobId + ", clientName=" + clientName + ", numberOfPositions="
				+ numberOfPositions + ", skillSetRequired=" + skillSetRequired + ", location=" + location + "]";
	}
	
	
	
	
	
	
}
