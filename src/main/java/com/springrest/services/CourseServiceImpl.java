/*
 * package com.springrest.services;
 * 
 * import java.util.ArrayList; import java.util.List; import
 * java.util.stream.Collector; import java.util.stream.Collectors;
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import com.springrest.entities.Course;
 * 
 * @Service public class CourseServiceImpl implements CourseService {
 * 
 * List<Course> list; public CourseServiceImpl() { list=new ArrayList<>();
 * list.add(new Course(1, "Core Java", 3000, "This is the core java course"));
 * list.add(new Course(2, "Python", 5000, "This is the python course"));
 * list.add(new Course(3, "React JS", 3000, "This is the React course")); }
 * 
 * @Override public List<Course> getCourses() { return this.list; }
 * 
 * @Override public Course getCourse(long l) { Course c=null; for(Course i:list)
 * { if(i.getId()==l) { c=i; break; } } return c; }
 * 
 * @Override public void addCourse(Course c) { list.add(c); }
 * 
 * @Override public Course updateCourse(Course c) { list.forEach(e->{
 * if(e.getId()==c.getId()) { e.setName(c.getName()); e.setPrice(c.getPrice());
 * e.setDescription(c.getDescription()); } }); return c; }
 * 
 * @Override public void deleteCourse(long courseId) {
 * list=list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList()
 * ); }
 * 
 * }
 */

package com.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	public CourseServiceImpl()
	{
		
	}
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(long l) {
		
		return courseDao.findById(l).get();
	}
	@Override
	public void addCourse(Course c) {
		courseDao.save(c);
	}
	@Override
	public Course updateCourse(Course c) {
		courseDao.save(c);
		return c;
	}
	@Override
	public void deleteCourse(long courseId) {
		courseDao.delete(courseDao.findById(courseId).get());
	}

}
