package com.klef.ep.models;
import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="grievance_table1")
public class EmpGrievance implements Serializable
{
	      @Id
	      @Column(name="ticket_id",nullable = false,length=50)
	      private int ticket_id;
	      @Column(name="ticket_raiser",nullable = false,length=100)
	      private String ticket_raiser;
	      @Column(name="email",nullable = false,length=100)
	      private String email;
	      @Column(name="contact",nullable=false,length=15)
	      private String  contact;
	      @Column(name="grievanceType",nullable = false,length=50)
	      private String grievanceType;
	      @Column(name="grievanceDetails",nullable = false,length=250)
	      private String grievanceDetails;
	      @Column(name="incidentLocation",nullable = false,length=35)
	      private String incidentLocation;
	      @Column(name="dateofincident",nullable=false,length=20)
	      private Date  dateofincident;
	      @Column(name="responsiblePerson",nullable = false,length=100)
	        private String responsiblePerson;
	      @Column(name="gre_status",nullable = false,length=100)
	        private String gre_status;

	  
	      
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
	    public String getGre_status() {
	      return gre_status;
	    }
	    public void setGre_status(String gre_status) {
	      this.gre_status = gre_status;
	    }
	      
	}
