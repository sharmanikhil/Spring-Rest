package com.springrest.services;

import java.util.List;

import com.springrest.entities.Course;
public interface CourseService {
	List<Course> getCourses();

	Course getCourse(long l);

	void addCourse(Course c);

	Course updateCourse(Course c);

	void deleteCourse(long courseId);
}
