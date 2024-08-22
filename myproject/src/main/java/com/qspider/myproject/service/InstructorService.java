package com.qspider.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qspider.myproject.entity.Instructor;
import com.qspider.myproject.repo.InstructorRepository;

@Service
	public class InstructorService {
	    @Autowired
	    private InstructorRepository instructorRepository;

	    public List<Instructor> getAllInstructors() {
	        return instructorRepository.findAll();
	    }

	    public Instructor saveInstructor(Instructor instructor) {
	        return instructorRepository.save(instructor);
	    }

	    public Instructor findInstructorById(int id) {
	        return instructorRepository.findById(id).orElse(null);
	    }

	    public void deleteInstructorById(int instructorId) {
	        instructorRepository.deleteById(instructorId);
	    }
	}


