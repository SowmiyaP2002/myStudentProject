package com.qspider.myproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qspider.myproject.entity.Course;
import com.qspider.myproject.entity.Instructor;
import com.qspider.myproject.service.CourseService;
import com.qspider.myproject.service.InstructorService;

@Controller
	@RequestMapping("/instructors")
	public class InstructorController {
	    @Autowired
	    private InstructorService instructorService;

	    @Autowired
	    private CourseService courseService;

	    @GetMapping("/create-course")
	    public String createCourseForm(Model model) {
	        model.addAttribute("course", new Course());
	        return "instructor/create-course";
	    }

	    @PostMapping("/create-course")
	    public String createCourse(@ModelAttribute Course course, @RequestParam int instructorId) {
	        Instructor instructor = instructorService.findInstructorById(instructorId);
	        if (instructor != null) {
	            course.setInstructor(instructor);
	            courseService.saveCourse(course);
	            return "redirect:/instructors/my-courses/" + instructorId;
	        }
	        return "redirect:/instructors/create-course";
	    }

	    @GetMapping("/my-courses/{instructorId}")
	    public String viewMyCourses(@PathVariable int instructorId, Model model) {
	        Instructor instructor = instructorService.findInstructorById(instructorId);
	        if (instructor != null) {
	            List<Course> courses = instructor.getCourses();
	            model.addAttribute("courses", courses);
	            return "instructor/my-courses";
	        }
	        return "redirect:/instructors/create-course";
	    }

	    @GetMapping("/add-materials/{courseId}")
	    public String addMaterialsForm(@PathVariable int courseId, Model model) {
	        Course course = courseService.findCourseById(courseId);
	        if (course != null) {
	            model.addAttribute("course", course);
	            return "instructor/add-materials";
	        }
	        return "redirect:/instructors/my-courses";
	    }

	    @PostMapping("/add-materials/{courseId}")
	    public String addMaterials(@PathVariable int courseId, @RequestParam List<String> materials) {
	        Course course = courseService.findCourseById(courseId);
	        if (course != null) {
	            course.getMaterials().addAll(materials);
	            courseService.saveCourse(course);
	            return "redirect:/instructors/my-courses/" + course.getInstructor().getId();
	        }
	        return "redirect:/instructors/my-courses";
	    }

	    @GetMapping("/grade-assignments/{courseId}")
	    public String gradeAssignmentsForm(@PathVariable int courseId, Model model) {
	        Course course = courseService.findCourseById(courseId);
	        if (course != null) {
	            model.addAttribute("course", course);
	            // Logic for fetching assignments and grades would go here
	            return "instructor/grade-assignments";
	        }
	        return "redirect:/instructors/my-courses";
	    }

	    @PostMapping("/grade-assignments/{courseId}")
	    public String gradeAssignments(@PathVariable int courseId, @RequestParam List<Integer> studentIds, @RequestParam List<Integer> grades) {
	        Course course = courseService.findCourseById(courseId);
	        if (course != null) {
	            // Logic to save grades for students would go here
	            return "redirect:/instructors/my-courses/" + course.getInstructor().getId();
	        }
	        return "redirect:/instructors/my-courses";
	    }
	}


