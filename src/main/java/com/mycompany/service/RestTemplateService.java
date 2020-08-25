package com.mycompany.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mycompany.dto.Employee;

/**
 * This class serves as service layer.
 * Makes the use of available dummy api to get data.
 * JSON format used for communication.
 * 
 * @author Sonal
 *
 */
@Service
public class RestTemplateService {
	RestTemplate restTemplate = new RestTemplate();
	String result = null;
	String className = RestTemplateService.class.getSimpleName();

	/**
	 * This method used for get all details of all employee.
	 * @return String
	 */
	public String getAllEmployees() {
		final String methodName = "getAllEmployees";
		try {
			final String uri = "http://dummy.restapiexample.com/api/v1/employees";
			result = restTemplate.getForObject(uri, String.class);
		} catch (Exception e) {
			System.out.println(className + " : " + methodName + e.getLocalizedMessage());
		}
		return result;
	}

	/**
	 * This method used for get all detail of specific employee.
	 * @param id
	 * @return object of ResponseEntity
	 */
	public ResponseEntity<String> getEmployeeById(int id) {
		final String methodName = "getEmployeeById";
		try {
			final String uri = "http://dummy.restapiexample.com/api/v1/employee/{id}";
			result = restTemplate.getForObject(uri, String.class, id);
		} catch (Exception e) {
			System.out.println(className + " : " + methodName + e.getLocalizedMessage());
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	/**
	 * This method descities the simple use of POST method
	 * @return object of ResponseEntity
	 */
	public ResponseEntity<String> createEmployee() {
		final String methodName = "createEmployee";
		try {
			final String uri = "http://dummy.restapiexample.com/api/v1/create";
			Employee newEmployee = new Employee();
			newEmployee.setName("John");
			newEmployee.setSalary("1000");
			newEmployee.setAge("12");
			result = restTemplate.postForObject(uri, newEmployee, String.class);
		} catch (Exception e) {
			System.out.println(className + " : " + methodName + e.getLocalizedMessage());
		}
		return new ResponseEntity(result, HttpStatus.CREATED);
	}
}
