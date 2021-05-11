package com.axxiome.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axxiome.springboot.schemas.school.Student;
import com.axxiome.springboot.schemas.school.StudentDetailsRequest;
import com.axxiome.springboot.schemas.school.StudentDetailsResponse;
import com.axxiome.springboot.soapservice.SOAPConnector;

@Service
public class StudentService {
	
	@Autowired
	SOAPConnector soapConnector;
	
	public Student getStudentByName(String name) {
		StudentDetailsRequest request = new StudentDetailsRequest();
		request.setName(name);
		StudentDetailsResponse response = (StudentDetailsResponse)soapConnector.callWebService("http://localhost:8080/service/student-details", request);
		
		return response.getStudent();
	} 
}
