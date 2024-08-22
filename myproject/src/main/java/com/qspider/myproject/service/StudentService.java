package com.qspider.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qspider.myproject.entity.Student;
import com.qspider.myproject.repo.StudentRepository;

@Service
	public class StudentService {
	    @Autowired
	    private StudentRepository studentRepository;

	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public Student saveStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    public Student findStudentById(int id) {
	        return studentRepository.findById(id).orElse(null);
	    }

	    public void enrollInCourse(int studentId, int courseId) {
	        Student student = findStudentById(studentId);
	        // Add course enrollment logic here
	        studentRepository.save(student);
	    }
      
	    public void deleteStudentById(int studentId) {
	        studentRepository.deleteById(studentId);
	    }
		

		
	}


