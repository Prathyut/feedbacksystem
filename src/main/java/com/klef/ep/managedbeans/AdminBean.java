package com.klef.ep.managedbeans;

import java.io.IOException;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Admin;
import com.klef.ep.services.AdminService;

@ManagedBean(name="adminbean",eager = true)

public class AdminBean 
{
	@EJB(lookup="java:global/FinalProject/AdminServiceImpl!com.klef.ep.services.AdminService")
	  AdminService adminService;
		
	  private String username;
	  private String password;
	  public String getUsername() 
	  {
		return username;
	}
	@Override
	public String toString() 
	{
		return "AdminBean [username=" + username + ", password=" + password + "]";
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	  public void validateadminlogin() throws IOException
	  {
		 FacesContext facesContext = FacesContext.getCurrentInstance();
	     ExternalContext externalContext = facesContext.getExternalContext();
		
	     HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		 HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		 Admin admin = adminService.checkadminlogin(username, password);
		 
		 if(admin!=null)
		 {
		   HttpSession session = request.getSession();
		   session.setAttribute("admin", admin); // admin session attribute
			
		   response.sendRedirect("adminhome.jsp");
		 }
		 else
		 {
			response.sendRedirect("adminloginfail.jsf");
		 }
	  }
	  
	  public String updateRedirect(Integer id, String fullname, String email, String gender, String marital_status, String contactno, BigDecimal salary,String status) {
	        // Construct the URL with all parameters
	        return "updateallemp.xhtml?faces-redirect=true&id=" + id +
	                "&fullname=" + fullname +
	                "&email=" + email +
	                "&gender=" + gender +
	                "&marital_status=" + marital_status +
	                "&contactno=" + contactno +
	                "&salary=" + salary.toString() +
	                "&status=" +status ;
	    }
	  
	  public String updategreRedirect(String ticket_id,String ticket_raiser, String responsiblePerson, String gre_status)
	    {
	      return "update_gstatus.xhtml?faces-redirect=true&ticket_id=" + ticket_id+
	          "&ticket_raiser=" + ticket_raiser +
	              "&responsible_person=" + responsiblePerson +
	              "&gre_status=" + gre_status ;
	    }
	  
	  
	  public String updateempgreRedirect(String ticket_id,String ticket_raiser, String responsiblePerson, String gre_status)
	    {
	      return "update_gre_status.xhtml?faces-redirect=true&ticket_id=" + ticket_id+
	          "&ticket_raiser=" + ticket_raiser +
	              "&responsible_person=" + responsiblePerson +
	              "&gre_status=" + gre_status ;
	    }

}