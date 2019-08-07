package com.meeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.Volunteer;
import com.meeting.repository.VolunteerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest")
public class VolunteerController {
	@Autowired
	VolunteerRepository volunteerRepository;
	@PostMapping("/volunteer-application")
	public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {
		MailController.sendEmail(volunteer.getEmail(), volunteer);
		return volunteerRepository.save(volunteer);
	}
	@GetMapping("/volunteer-application")
	public List<Volunteer> getVolunteers() {
		//go to repo and fetch all users 
		return volunteerRepository.findAll();
	}
	@DeleteMapping("/volunteer-application/{id}")
	public String deleteVolunteers(@PathVariable("id") int id) {
		//go to repo and fetch all users 
		 volunteerRepository.deleteById(id);
		 return "Deleted Successfully";
	}
	@PutMapping("/volunteer-application/{id}")
	public Volunteer updateMeeting(@PathVariable("id") int id, @RequestBody Volunteer v) {
		//go to repo and fetch existing meeting based on id
		Volunteer temp = volunteerRepository.getOne(id);
		temp.setAge(v.getAge());
		temp.setArea_comfortable(v.getArea_comfortable());
		temp.setAwareness_source(v.getAwareness_source());
		temp.setCurrent_working_details(v.getCurrent_working_details());
		temp.setDate(v.getDate());
		temp.setDay1(v.getDay1());
		temp.setDay2(v.getDay2());
		temp.setDay3(v.getDay3());
		temp.setEducation(v.getEducation());
		temp.setEmail(v.getEmail());
		temp.setGender(v.getGender());
		temp.setMonths_available(v.getMonths_available());
		temp.setPhoneno(v.getPhoneno());
		temp.setPrior_teaching_experience(v.getPrior_teaching_experience());
		temp.setRecent_education(v.getRecent_education());
		temp.setResidential_address(v.getResidential_address());
		temp.setVolunteering_cause(v.getVolunteering_cause());
		temp.setTime_slot(v.getTime_slot());
		temp.setSkill_set(v.getSkill_set());
		return volunteerRepository.save(temp);
		
	}
}
