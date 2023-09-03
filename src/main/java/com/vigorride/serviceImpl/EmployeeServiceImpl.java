package com.vigorride.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vigorride.entity.User;
import com.vigorride.service.EmployeeService;
import com.vigorride.signup.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private final UserRepository employeeRepository;
	
   
    
	@Override
	public List<User> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
