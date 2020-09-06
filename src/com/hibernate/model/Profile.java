package com.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profile")
public class Profile
{
	@Id
	@Column(name="ID")
	private int profileId;
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(int profileId,String creationDate, PersonalDetails perInfo, EducationalDetails eduInfo) {
		super();
		this.profileId = profileId;
		this.creationDate = creationDate;
		this.perInfo = perInfo;
		this.eduInfo = eduInfo;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", creationDate=" + creationDate + ", perInfo=" + perInfo
				+ ", eduInfo=" + eduInfo + ", getProfileId()=" + getProfileId() + ", getCreationDate()="
				+ getCreationDate() + ", getPerInfo()=" + getPerInfo() + ", getEduInfo()=" + getEduInfo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public PersonalDetails getPerInfo() {
		return perInfo;
	}

	public void setPerInfo(PersonalDetails perInfo) {
		this.perInfo = perInfo;
	}

	public EducationalDetails getEduInfo() {
		return eduInfo;
	}

	public void setEduInfo(EducationalDetails eduInfo) {
		this.eduInfo = eduInfo;
	}

	@Column(name="CDate")
	private String creationDate;
	
	@Column(name="PDetails")
	PersonalDetails perInfo;
	
	@Column(name="EDetails")
	EducationalDetails eduInfo;
	
}
