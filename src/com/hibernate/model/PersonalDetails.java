package com.hibernate.model;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class PersonalDetails 
{
	String firstName;
	String lastName;
	String contactNo;
	String email;
	String gender;
	String birthDate;
	@Override
	public String toString() {
		return "PersonalDetails [firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", email=" + email + ", gender=" + gender + ", birthDate=" + birthDate + ", resAddr=" + resAddr
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getContactNo()="
				+ getContactNo() + ", getEmail()=" + getEmail() + ", getGender()=" + getGender() + ", getBirthDate()="
				+ getBirthDate() + ", getResAddr()=" + getResAddr() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalDetails(String firstName, String lastName, String contactNo, String email, String gender,
			String birthDate, Address resAddr) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.gender = gender;
		this.birthDate = birthDate;
		this.resAddr = resAddr;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Address getResAddr() {
		return resAddr;
	}
	public void setResAddr(Address resAddr) {
		this.resAddr = resAddr;
	}
	Address resAddr;
	

}
