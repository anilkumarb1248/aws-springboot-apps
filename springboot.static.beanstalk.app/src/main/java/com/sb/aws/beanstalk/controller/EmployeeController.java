package com.sb.aws.beanstalk.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.aws.beanstalk.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/list")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (long i = 1; i <= 10; i++) {
			Employee emp = new Employee(i, "Employee_" + i, 10000.00);
			employees.add(emp);
		}
		return employees;
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long empId) {
		LOGGER.info("fetching the employee with id: {}", empId);
		return new Employee(empId, "Anil Kumar", 11111.00);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		LOGGER.info("Got new employee details: {}", employee);
		return ResponseEntity.status(HttpStatus.OK).body("Employee added successfully");
	}

}
