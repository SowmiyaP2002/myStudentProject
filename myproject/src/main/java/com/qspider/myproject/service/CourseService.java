package com.qspider.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qspider.myproject.entity.Course;
import com.qspider.myproject.repo.CourseRepository;

@Service
	public class CourseService {
	    @Autowired
	    private CourseRepository courseRepository;

	    public List<Course> getAllCourses() {
	        return courseRepository.findAll();
	    }

	    public Course saveCourse(Course course) {
	        return courseRepository.save(course);
	    }

	    public Course findCourseById(int id) {
	        return courseRepository.findById(id).orElse(null);
	    }

		 public void deleteCourseById(int courseId) {
        courseRepository.deleteById(courseId);
    }
	}


