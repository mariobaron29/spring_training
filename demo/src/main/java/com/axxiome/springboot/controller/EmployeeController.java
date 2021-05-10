package com.axxiome.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axxiome.springboot.model.Employee;
import com.axxiome.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllemployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}") 
	public Employee getEmployeeById(@PathVariable (value = "id") Long employeeId){
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping 
	public Employee createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}
}

