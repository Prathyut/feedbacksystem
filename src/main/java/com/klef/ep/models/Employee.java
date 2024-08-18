package com.klef.ep.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="employee_table1")
public class Employee implements Serializable
{
@Id
@Column(name="id")
private int id;
@Column(name="fullname",nullable = false,length=100)
private String fullname;
@Column(name="email",nullable = false,length=100,unique=true)
private String email;
@Column(name="password",nullable=false,length=20)
private String password;
@Column(name="dob",nullable=false,length=20)
private Date dob;
@Column(name="gender",nullable=false,length=10)
private String gender;
@Column(name="marital_status",nullable=false,length=10)
private String marital_status;
@Column(name="contactno",nullable=false,length=15,unique = true)
private String contactno;
@Column(name="address",nullable = false,columnDefinition = "TEXT")
private String address;
@Column(name="data_of_joining",nullable=false,length=20)
private Date date_of_joining;
@Column(name="salary",nullable=false,precision = 10, scale = 2)
private BigDecimal salary;
@Column(name="years_of_experience",nullable=false,length=5)
private int years_of_experience;
@Column(name="employee_type",nullable = false,length=20)
private String employee_type;
@Column(name="status",nullable=false,length=20)
private String status;


public int getId() {
  return id;
}
public void setId(int id) {
  this.id = id;
}
public String getFullname() {
  return fullname;
}
public void setFullname(String fullname) {
  this.fullname = fullname;
}
public String getEmail() {
  return email;
}
public void setEmail(String email) {
  this.email = email;
}
public String getPassword() {
  return password;
}
public void setPassword(String password) {
  this.password = password;
}
public Date getDob() {
  return dob;
}
public void setDob(Date dob) {
  this.dob = dob;
}
public String getGender() {
  return gender;
}
public void setGender(String gender) {
  this.gender = gender;
}
public String getMarital_status() {
  return marital_status;
}
public void setMarital_status(String marital_status) {
  this.marital_status = marital_status;
}

public String getContactno() {
  return contactno;
}
public void setContactno(String contactno) {
  this.contactno = contactno;
}
public String getAddress() {
  return address;
}
public void setAddress(String address) {
  this.address = address;
}


public Date getDate_of_joining() {
  return date_of_joining;
}
public void setDate_of_joining(Date date_of_joining) {
  this.date_of_joining = date_of_joining;
}
public BigDecimal getSalary() {
  return salary;
}
public void setSalary(BigDecimal salary) {
	  this.salary = salary;
	}
	public int getYears_of_experience() {
	  return years_of_experience;
	}
	public void setYears_of_experience(int years_of_experience) {
	  this.years_of_experience = years_of_experience;
	}
	
	public String getEmployee_type() {
	  return employee_type;
	}
	public void setEmployee_type(String employee_type) {
	  this.employee_type = employee_type;
	}
	public String getStatus() {
	  return status;
	}
	public void setStatus(String status) {
	  this.status = status;
	}
	

	}