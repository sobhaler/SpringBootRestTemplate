package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.service.RestTemplateService;

/**
 * This is the class for controller which executed the handler methods.
 * @author Sonal
 *
 */
@RestController
public class RestTemplateController {
	
	@Autowired
	RestTemplateService RestTemplateService;
	
	@RequestMapping("/check")
	public String checkConnection()
	{
		return "Welcome";
	}

	/**
	 * This method used for get all details of all employee in JSON format.
	 * @return String
	 */
	@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public String getAllEmployees() 
	{
		return RestTemplateService.getAllEmployees();
	}
	
	/**
	 * This method used for get all detail of specific employee.
	 * @param id
	 * @return object of ResponseEntity
	 */
	@RequestMapping(value = "/employees/{id}")
	public ResponseEntity<String> getEmployeeById (@PathVariable("id") int id)
	{
		return RestTemplateService.getEmployeeById(id);
	}
	
	/**
	 * This method descities the simple use of POST method
	 * @return object of ResponseEntity
	 */
	@RequestMapping(value = "/createEmployees")
	public ResponseEntity<String> createEmployee() 
	{
		return RestTemplateService.createEmployee();
	}
}
