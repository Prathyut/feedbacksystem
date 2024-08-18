package com.klef.ep.managedbeans;
import java.io.IOException;
import java.util.Date;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.EmpGrievance;
import com.klef.ep.models.HRSE;
import com.klef.ep.services.HRService;
import com.klef.ep.services.HRServiceImpl;


@ManagedBean(name = "hr", eager = true)
public class HRBean 
{
	    public String getGre_status() {
	    return gre_status;
	  }

	  public void setGre_status(String gre_status) {
	    this.gre_status = gre_status;
	  }
	  @EJB(lookup = "java:global/FinalProject/HRServiceImpl!com.klef.ep.services.HRService")
	    HRService service;
	  
	  
	  private String username;
	  private String password;
	    
	    private int ticket_id;
	    private String ticket_raiser;
	    private String email;
	    private String contact;
	    private String grievanceType;
	    private String grievanceDetails;
	    private String incidentLocation;
	    private Date dateofincident;
	    private String responsiblePerson;
	    private String gre_status;
	    //private List<EmpGrievance> grelist;
	    //private List<EmpGrievance> mygre;

	    public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		private List<EmpGrievance> grelist;
	    private List<EmpGrievance> mygre;

	    public List<EmpGrievance> getGrelist() {
	      return service.viewallgre();
	    }
	    
	    public void setMyGrelist(List<EmpGrievance> grelist) {
	        this.grelist = grelist;
	      }
	    public List<EmpGrievance> getMyGrelist() {
	        return service.mygre();
	      }
	    
	    public String addGrievance(String fullname) {
	        EmpGrievance grievance = new EmpGrievance();
	        
	        // Generate random ticket id
	        int ticket_id = (int) (Math.random() * 9000) + 10000;
	        grievance.setTicket_id(ticket_id);
	        grievance.setTicket_raiser(fullname); // Assuming fullname is accessible here
	        grievance.setEmail(email);
	        grievance.setContact(contact);
	        grievance.setGrievanceType(grievanceType);
	        grievance.setGrievanceDetails(grievanceDetails);
	        grievance.setIncidentLocation(incidentLocation);
	        grievance.setDateofincident(dateofincident);
	        grievance.setResponsiblePerson(responsiblePerson);
	        grievance.setGre_status("Submitted");
	        
	        String result = service.addGrievance(grievance); // Assuming service is injected and handles grievance addition
	        
	        // Redirect to gresuccess.xhtml with ticket_id parameter
	        return "GrieSuccess.xhtml?faces-redirect=true&ticket_id=" + ticket_id;
	    }

	    public int getTicket_id() {
	        return ticket_id;
	    }

	    public void setTicket_id(int ticket_id) {
	        this.ticket_id = ticket_id;
	    }

	    public String getTicket_raiser() {
	        return ticket_raiser;
	    }

	    public void setTicket_raiser(String ticket_raiser) {
	        this.ticket_raiser = ticket_raiser;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getContact() {
	        return contact;
	    }

	    public void setContact(String contact) {
	        this.contact = contact;
	    }

	    public String getGrievanceType() {
	        return grievanceType;
	    }

	    public void setGrievanceType(String grievanceType) {
	        this.grievanceType = grievanceType;
	    }

	    public String getGrievanceDetails() {
	        return grievanceDetails;
	    }

	    public void setGrievanceDetails(String grievanceDetails) {
	        this.grievanceDetails = grievanceDetails;
	    }

	    public String getIncidentLocation() {
	        return incidentLocation;
	    }

	    public void setIncidentLocation(String incidentLocation) {
	        this.incidentLocation = incidentLocation;
	    }

	    public Date getDateofincident() {
	        return dateofincident;
	    }

	    public void setDateofincident(Date dateofincident) {
	        this.dateofincident = dateofincident;
	    }

	    public String getResponsiblePerson() {
	        return responsiblePerson;
	    }

	    public void setResponsiblePerson(String responsiblePerson) {
	        this.responsiblePerson = responsiblePerson;
	    }
	    public String deletegre(int ticket_id) {
	        service.deletegre(ticket_id);
	        return "viewgre.jsf";
	    }

	    
	    public String updategrestatus()
	    {
	    EmpGrievance e = service.viewgrebyid(ticket_id);
	    if(e!=null)
	    {
	      //System.out.println("ID Found");
	      EmpGrievance gre = new EmpGrievance();
	      gre.setTicket_id(ticket_id);
	      gre.setEmail(email);
	      gre.setTicket_raiser(ticket_raiser);
	      gre.setResponsiblePerson(responsiblePerson);
	      gre.setGre_status(gre_status);

	      
	      service.updategrestatus(gre);
	      
	     return "updatesuccess.jsf";
	    }
	    else
	    {
	   return "updatefail.jsf";

	    }
	    }
	    
	    public void validatehrlogin() throws IOException
		  {
			 FacesContext facesContext = FacesContext.getCurrentInstance();
		     ExternalContext externalContext = facesContext.getExternalContext();
			
		     HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			 HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
			
			HRSE hrs=service.checkhrlogin(username,password);
			 
			 if(hrs!=null)
			 {
			   HttpSession session = request.getSession();
			   session.setAttribute("hr", hrs); 
				
			   response.sendRedirect("hrhome.jsf");
			 }
			 else
			 {
				response.sendRedirect("hrloginfail.jsf");
			 }
		  }
	    
	    
	    
}
