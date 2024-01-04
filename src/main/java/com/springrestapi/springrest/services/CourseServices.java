package com.springrestapi.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springrestapi.springrest.entities.Courses;

public interface CourseServices {

	@Autowired
	public List<Courses> getCourses();
	public Courses getCourses(long courseId);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses courses);
	public void deleteCourse(long parseLong);
}
