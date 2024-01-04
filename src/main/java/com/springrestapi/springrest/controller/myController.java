package com.springrestapi.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.springrest.entities.Courses;
import com.springrestapi.springrest.services.CourseServiceImple;
import com.springrestapi.springrest.services.CourseServices;

@RestController
public class myController {
	@Autowired
	private CourseServiceImple courseServices;
	
	@GetMapping("/home")
	public String home() {
		return "This is a home Page";
	}
	//,consumes = "application/json" 
	// get the courses
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		return this.courseServices.getCourses();
	}
	//get courses from ID
	@GetMapping("/courses/{courseId}")
	public Courses getCourses(@PathVariable String courseId) {
		
		return this.courseServices.getCourses(Long.parseLong(courseId));
	}
 // add Course 
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses courses) {
		return this.courseServices.addCourse(courses);
	}
	
	//update course 
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses courses) {
		return this.courseServices.updateCourse(courses);
	}
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseServices.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
