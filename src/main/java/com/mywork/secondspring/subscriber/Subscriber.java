package com.mywork.secondspring.subscriber;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Subscriber {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	
	@Column
	@CreationTimestamp
	private Date signedUp;
	
	public Subscriber() {};
	
    public Subscriber(String firstName, String lastName, String username, Date signedUp){
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.signedUp = signedUp;
}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public Long getId() {
		return id;
	}

	public void setSignedUp(Date signedUp) {
		this.signedUp = signedUp;
	}

	public Date getSignedUp() {
		return signedUp;
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", signedUp=" + signedUp + "]";
	}



	
}
