package com.dev;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

/*
 * This class represents a user of the ArtistPortfolio system.  This is one of 
 * our applications main domain objects.
 */

@Table(name="USERS")
@Entity
public class USERS {

	@Id
	private int id;
	
	@Column(name="user_first")
	private String first;
	
	@Column(name="user_last")	
	private String last;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_active")
	private int active;
	
	
	/*************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}

}
