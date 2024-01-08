package com.springboot.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Entity
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leadId;
	
	@NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String middleName;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String lastName;
	 
	@NotBlank
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobileNumber;
	
	@NotBlank
    @Pattern(regexp = "^(Male|Female|Others)$")
	private String gender;
	
	@NotNull
    @Temporal(TemporalType.DATE)
    @Past
	private Date dob;
	
	@NotBlank
    @Email
    private String email;

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
