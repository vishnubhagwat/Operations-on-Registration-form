package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EducationalDetails
{
	@Column(name="qual")
	String qualification;
	
	@Column(name="res")
	String result;
	
	@Column(name="year")
	int yearPassing;

	public EducationalDetails(String qualification, String result, int yearPassing) {
		super();
		this.qualification = qualification;
		this.result = result;
		this.yearPassing = yearPassing;
	}

	public EducationalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EducationalDetails [qualification=" + qualification + ", result=" + result + ", yearPassing="
				+ yearPassing + ", getQualification()=" + getQualification() + ", getResult()=" + getResult()
				+ ", getYearPassing()=" + getYearPassing() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getYearPassing() {
		return yearPassing;
	}

	public void setYearPassing(int yearPassing) {
		this.yearPassing = yearPassing;
	}
	

}
