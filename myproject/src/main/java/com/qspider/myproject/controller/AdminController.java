package com.qspider.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qspider.myproject.entity.Course;
import com.qspider.myproject.entity.Instructor;
import com.qspider.myproject.entity.Student;
import com.qspider.myproject.service.CourseService;
import com.qspider.myproject.service.InstructorService;
import com.qspider.myproject.service.StudentService;

@Controller
	@RequestMapping("/admin")
	public class AdminController {
	    @Autowired
	    private StudentService studentService;

	    @Autowired
	    private InstructorService instructorService;

	    @Autowired
	    private CourseService courseService;

	    @GetMapping("/manage-users")
	    public String manageUsers(Model model) {
	        List<Student> students = studentService.getAllStudents();
	        List<Instructor> instructors = instructorService.getAllInstructors();
	        model.addAttribute("students", students);
	        model.addAttribute("instructors", instructors);
	        return "admin/manage-users";
	    }

	    @GetMapping("/manage-courses")
	    public String manageCourses(Model model) {
	        List<Course> courses = courseService.getAllCourses();
	        model.addAttribute("courses", courses);
	        return "admin/manage-courses";
	    }

	    @PostMapping("/delete-user/{userId}")
	    public String deleteUser(@PathVariable int userId, @RequestParam String userType) {
	        if ("student".equals(userType)) {
	            studentService.deleteStudentById(userId);
	        } else if ("instructor".equals(userType)) {
	            instructorService.deleteInstructorById(userId);
	        }
	        return "redirect:/admin/manage-users";
	    }

	    @PostMapping("/delete-course/{courseId}")
	    public String deleteCourse(@PathVariable int courseId) {
	        courseService.deleteCourseById(courseId);
	        return "redirect:/admin/manage-courses";
	    }
	}


