package com.klef.ep.managedbeans;

import java.io.IOException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Employee;
import com.klef.ep.services.EmployeeService;

@ManagedBean(name = "emp",eager =true)
public class EmployeeBean 
{
  
  @EJB(lookup = "java:global/FinalProject/EmployeeServiceImpl!com.klef.ep.services.EmployeeService")
  EmployeeService service;
    private int id;
    private String fullname;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String marital_status;
    private String contactno;
    private String address;
    private Date date_of_joining;
    private BigDecimal salary;
    private int years_of_experience;
    private String employee_type;
    private String status;
    
   
    
    private List<Employee> emplist;
	private String newpassword;

    public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
     }

	public List<Employee> getEmplist() {
      return service.viewallemps();
    }
    
    public void setEmplist(List<Employee> emplist) {
        this.emplist = emplist;
      }
    
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
  
  
  
  public String add()
  {
    Employee e = new Employee();
    int id = (int) (Math.random() * 900) + 100;
    e.setId(id);
    e.setFullname(fullname);
    e.setEmail(email);
    e.setPassword("klu123");
    e.setDob(dob);
    e.setGender(gender);
    e.setMarital_status(marital_status);
   
    e.setContactno(contactno);
    e.setAddress(address);
    
    e.setDate_of_joining(date_of_joining);
    e.setSalary(salary);
    e.setYears_of_experience(years_of_experience);
    e.setEmployee_type(employee_type);
    e.setStatus(status);
    
    
    String res = service.addemployee(e);
    
      return "empreg.jsf?faces-redirect=true"; // This will reset the form submission

  }
  
  public void validatelogin() throws IOException
  {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
	    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	  
	  Employee e=service.checkemplogin(email, password);
	  if(e!=null)
	  {
		 // return "emphome.jsf";
		  
		  HttpSession session =request.getSession(); //explicit object
		  session.setAttribute("emps", e); //emp is a session attribute of Employee
		  response.sendRedirect("emphome.jsp");
		  
	  }
	  else
	  {
		  //return "loginfail.jsf";
		  response.sendRedirect("loginfail.jsf");
	  }
  }
  
  public String delete(int id)
  {
    service.deleteemployee(id);
    
    return "viewallemp.jsf";
  }
  
  public String update() {
      Employee e = service.viewempbyid(id);
      if (e != null) {
          Employee emp = new Employee();
          emp.setId(id);
          emp.setFullname(fullname);
          emp.setEmail(email);
          emp.setGender(gender);
          emp.setMarital_status(marital_status);
          emp.setContactno(contactno);
          emp.setSalary(salary);
          emp.setStatus(status);
          

          service.updateallemp(emp);

          return "updatesuccess.jsf";
      } else {
          return "updatefail.jsf";
      }
  }
  
  
  
     
     public String updatepwd(int id) {
         Employee e = service.viewempbyid(id);
         if (e != null) {
             e.setPassword(newpassword);
             service.updatepwd(e);

             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password updated successfully."));

             try {
                 FacesContext.getCurrentInstance().getExternalContext().redirect("emplogin.jsf");
             } catch (IOException ex) {
                 ex.printStackTrace();
             }

             return null;
         } else {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID not found."));
             return "updatefail.jsf";
         }
     }

	
  
  
}