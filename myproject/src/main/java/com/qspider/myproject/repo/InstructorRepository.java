package com.qspider.myproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspider.myproject.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
	}


