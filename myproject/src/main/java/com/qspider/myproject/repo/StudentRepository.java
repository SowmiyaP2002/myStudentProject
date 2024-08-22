package com.qspider.myproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspider.myproject.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	}


