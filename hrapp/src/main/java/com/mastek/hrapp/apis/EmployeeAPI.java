	package com.mastek.hrapp.apis;

	import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;

	import com.mastek.hrapp.entities.Employee;

	@Path("/hrapp") //url pattern to access the current API interface
	public interface EmployeeAPI {

	@GET //we do support http method: GET
	@Path("/employees/list") //URL path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //formats which the method supports.
	public Iterable<Employee> listAllEmployees();
	
	
	@GET
	@Path("/employees/find/{empno}")
	@Produces({MediaType.APPLICATION_JSON})
	public Employee findByEmpno(@PathParam("empno") int empno);
	
	
	@POST
	@Path("/employees/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee registerNewEmployee(@BeanParam Employee newEmployee);
}

/*
@GET
@Path("/employees/find/{empno}")
@Produces({MediaType.APPLICATION_JSON})
public Employee findByEmpno(@PathParam("empno") int empno);

@POST
@Path("/employees/register")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public Employee registerNewEmployee(Employee newEmployee);*/



