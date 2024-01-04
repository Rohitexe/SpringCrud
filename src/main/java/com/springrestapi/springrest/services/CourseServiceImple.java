package com.springrestapi.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.springrest.dao.CourseDao;
import com.springrestapi.springrest.entities.Courses;

@Service
public class CourseServiceImple implements CourseServices {

	@Autowired
	private CourseDao courseDao;
	
	
	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Courses getCourses(long courseId) {

		return courseDao.getOne(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}
	@Override
	public Courses updateCourse(Courses courses) {
		courseDao.save(courses);
	    return courses;
	}
	@Override
	public void deleteCourse(long parseLong) {
	  @SuppressWarnings("deprecation")
	Courses entity = courseDao.getById(parseLong);
	  courseDao.delete(entity);
	}

}
