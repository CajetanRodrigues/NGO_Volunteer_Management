package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.model.Volunteer;


public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {

}
