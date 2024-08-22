package com.qspider.myproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspider.myproject.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	}


