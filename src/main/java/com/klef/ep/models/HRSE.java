package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="hr_table1")

public class HRSE implements Serializable
{
		@Id //primary key = unique+not null
		@Column(name="husername",length=30) //if length not mentioned by default length =255
		private String username;
		@Column(name="hpassword",length=30,nullable=false)
		private String password;
		private String email;

	    // Getter and Setter for email
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

		
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

}
