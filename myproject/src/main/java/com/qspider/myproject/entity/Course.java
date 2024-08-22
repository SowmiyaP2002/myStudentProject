package com.qspider.myproject.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
	public class Course {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String title;
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "instructor_id")
	    private Instructor instructor;

	    @ManyToMany(mappedBy = "courses")
	    private List<Student> students;

	    @ElementCollection
	    private List<String> materials;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Instructor getInstructor() {
			return instructor;
		}

		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}

		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}

		public List<String> getMaterials() {
			return materials;
		}

		public void setMaterials(List<String> materials) {
			this.materials = materials;
		}

	    
	}
