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
import com.qspider.myproject.service.CourseService;
import com.qspider.myproject.service.StudentService;

@Controller
	@RequestMapping("/students")
	public class StudentController {
	    @Autowired
	    private StudentService studentService;

	    @Autowired
	    private CourseService courseService;

	    @GetMapping("/browse-courses")
	    public String browseCourses(Model model) {
	      List<Course> courses = courseService.getAllCourses();
	        model.addAttribute("courses", courses);
	        return "student/browse-courses";
	    }

	    @PostMapping("/enroll")
	    public String enrollInCourse(@RequestParam int studentId, @RequestParam int courseId) {
	        studentService.enrollInCourse(studentId, courseId);
	        return "redirect:/students/browse-courses";
	    }

	    @GetMapping("/view-materials/{courseId}")
	    public String viewMaterials(@PathVariable int courseId, Model model) {
	        Course course = courseService.findCourseById(courseId);
	        if (course != null) {
	            model.addAttribute("materials", course.getMaterials());
	            return "student/view-materials";
	        }
	        return "redirect:/students/browse-courses";
	    }

	    @GetMapping("/take-quiz/{courseId}")
	    public String takeQuiz(@PathVariable int courseId, Model model) {
	        Course course = courseService.findCourseById(courseId);
	        if (course != null) {
	            model.addAttribute("course", course);
	            // Here, you would normally fetch the quiz associated with the course and add it to the model
	            // For simplicity, I'm leaving this as is
	            return "student/take-quiz";
	        }
	        return "redirect:/students/browse-courses";
	    }
	}


