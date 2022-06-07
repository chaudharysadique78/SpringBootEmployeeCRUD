package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;

	@PostMapping("/employee")
	public Integer createEmployee(@RequestBody EmployeeEntity employee) {
		Integer id = employeeService.saveEmployee(employee);
		return id;
	}

	@GetMapping("/allemployee")
	public List<EmployeeEntity> getEmployees() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employee/{id}")
	public Optional<EmployeeEntity> getEmployee(@PathVariable Integer id) {
		return employeeService.getStudent(id);
	}

	@DeleteMapping("employee/{id}")
	public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable Integer id) {
		ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<EmployeeEntity>(HttpStatus.OK);
		try {
			employeeService.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee,
			@PathVariable Integer id) {
		ResponseEntity<EmployeeEntity> responseEntity = new ResponseEntity<EmployeeEntity>(HttpStatus.OK);
		try {
			employeeService.updateEmployee(employee, id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity=new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
