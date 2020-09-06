package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	@Column(name="Street")
	String Street;
	
	@Column(name="city")
	String City;
	
	@Override
	public String toString() {
		return "Address [Street=" + Street + ", City=" + City + ", Country=" + Country + ", Zip=" + Zip
				+ ", getStreet()=" + getStreet() + ", getCity()=" + getCity() + ", getCountry()=" + getCountry()
				+ ", getZip()=" + getZip() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String country, String zip) {
		super();
		Street = street;
		City = city;
		Country = country;
		Zip = zip;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	@Column(name="country")
	String Country;
	
	@Column(name="Zip")
	String Zip;
	

}
