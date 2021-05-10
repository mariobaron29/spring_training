package com.axxiome.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axxiome.springboot.exception.ResourceNotFoundException;
import com.axxiome.springboot.model.Employee;
import com.axxiome.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	private RestTemplate restTemplate = new RestTemplate();

	private static String GET_ALL_EMPLOYEES_API = "http://localhost:3000/employees";
	private static String GET_EMPLOYEE_BY_API = "http://localhost:3000/employees/{id}";
	private static String CREATE_EMPLOYEE_API = "http://localhost:3000/employees";
	private static String UPDATE_EMPLOYEE_API = "http://localhost:3000/employees/{id}";
	private static String DELETE_EMPLOYEE_API = "http://localhost:3000/employees/{id}";

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * 
		 * HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		 * ResponseEntity<List<Employee>> response =
		 * restTemplate.exchange(GET_ALL_EMPLOYEES_API, HttpMethod.GET, entity, new
		 * ParameterizedTypeReference<List<Employee>>() { });
		 * 
		 * if(response.getStatusCode().is2xxSuccessful()) { return response.getBody(); }
		 * else { // TODO: throw an exception return null; }
		 */
	}

	public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResourceNotFoundException("We couldn't find the employee");
		}
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 * 
		 * HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		 * ResponseEntity<Employee> response =
		 * restTemplate.exchange(GET_EMPLOYEE_BY_API, HttpMethod.GET, entity,
		 * Employee.class, id);
		 * 
		 * try { return response.getBody(); } catch(Exception e) {
		 * 
		 * throw new ResourceNotFoundException("We couldn't find the employee");
		 * 
		 * }
		 */
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
