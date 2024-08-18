package com.klef.ep.services;

import com.klef.ep.models.Employee;



import java.util.List;

public interface EmployeeService 
{

	 public String addemployee(Employee employee);//Registration

	public Employee checkemplogin(String email, String password);

	public List<Employee> viewallemps();

	public String deleteemployee(int id);

	public Employee viewempbyid(int id);

	public String updateallemp(Employee emp);
	
	public String updatepwd(Employee employee);

	
	

 
}
