package lk.ac.vau.fas.ict.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
	@RequestMapping("/app")
	public class AppController {
	
	Student Bob = new Student("2021IT01","Bob Marley",23,"IT",3.2);
	Student Alice = new Student("2021IT02","Alice Corner",23,"IT",3.2);
	Student Poori = new Student("2021IT03","Poori Magrat",23,"IT",3.2);
	
	List<Student> students= new ArrayList<Student>();
	
		@GetMapping("/msg")
		public String myMessage() {
		    return "Hello Springboot";
		}
		@GetMapping("/name")
		public String myName() {
		    return "My Name is Springboot";
		}
		@GetMapping("/age/{ag}")
		public String MyAge(@PathVariable("ag")int age) {
			return "My age is" +age;
		}
		//a method to return a student
		@GetMapping("/student")
		public Student getStudent() {
			return Bob;
		}
		//return Multiple students
		@GetMapping("/students")
		public List<Student> getStudents() {
			students.add(Alice);
			students.add(Bob);
			students.add(Poori);
			return students;
		}
		
		//find a student from the list by regno
		//find a student from the list by regno
		@GetMapping("/student/{id}")
		public Student getStudent(@PathVariable("id") String regno) {
			for (Student student:students) {
			if (student.getRegNo().equals(regno)) {
				return student;
			}
		}
		
		return null;
	}
}
	



