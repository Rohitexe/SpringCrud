package com.springrestapi.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.springrest.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long> {

	
}
