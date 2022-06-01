package com.springrest.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String hello() {
		return "Hello From Backend";
	}

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course c) {
		this.courseService.addCourse(c);
		return c;
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course c) {
		return this.courseService.updateCourse(c);
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
