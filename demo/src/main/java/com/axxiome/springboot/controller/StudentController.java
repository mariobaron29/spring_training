package com.axxiome.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axxiome.springboot.schemas.school.Student;
import com.axxiome.springboot.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/{name}") 
	public Student getStudentByName(@PathVariable (value = "name") String studentName){
		return studentService.getStudentByName(studentName);
	}
}
