package com.meeting.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Volunteer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(hidden=true)
	private int id;
	
	private String name;
	
	private String age;
	
	private String gender;
	
	private String phoneno;
	
	private String email;
	
	private String residential_address;
	
	private String education;
	
	private String recent_education;
	
	private String current_working_details;
	
	private String months_available;
	
	private String day1;
	
	private String day2;
	
	private String day3;
	
	private String time_slot;
	
	private String skill_set;
	
	private String area_comfortable;
	
	private String volunteering_cause;

	private String awareness_source;
	
	private String prior_teaching_experience;
	


	public String getPrior_teaching_experience() {
		return prior_teaching_experience;
	}

	public void setPrior_teaching_experience(String prior_teaching_experience) {
		this.prior_teaching_experience = prior_teaching_experience;
	}

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="ddMMyyyy")
	private Date date;
	
	
	public String getResidential_address() {
		return residential_address;
	}

	public void setResidential_address(String residential_address) {
		this.residential_address = residential_address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getRecent_education() {
		return recent_education;
	}

	public void setRecent_education(String recent_education) {
		this.recent_education = recent_education;
	}

	public String getCurrent_working_details() {
		return current_working_details;
	}

	public void setCurrent_working_details(String current_working_details) {
		this.current_working_details = current_working_details;
	}

	public String getMonths_available() {
		return months_available;
	}

	public void setMonths_available(String months_available) {
		this.months_available = months_available;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getDay3() {
		return day3;
	}

	public void setDay3(String day3) {
		this.day3 = day3;
	}

	public String getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}

	public String getSkill_set() {
		return skill_set;
	}

	public void setSkill_set(String skill_set) {
		this.skill_set = skill_set;
	}

	
	public String getArea_comfortable() {
		return area_comfortable;
	}

	public void setArea_comfortable(String area_comfortable) {
		this.area_comfortable = area_comfortable;
	}

	public String getVolunteering_cause() {
		return volunteering_cause;
	}

	public void setVolunteering_cause(String volunteering_cause) {
		this.volunteering_cause = volunteering_cause;
	}

	public String getAwareness_source() {
		return awareness_source;
	}

	public void setAwareness_source(String awareness_source) {
		this.awareness_source = awareness_source;
	}

	
	
	
	
	
	
}
