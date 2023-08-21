package com.vigorride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.entity.User;
import com.vigorride.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
		
	
	
	@GetMapping("/employees")
	public List<User> fetchAllEmployees() {
		 return employeeService.getAllEmployees();
	}
	
	
	
}
