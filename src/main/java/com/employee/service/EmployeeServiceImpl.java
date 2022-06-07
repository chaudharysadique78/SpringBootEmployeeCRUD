package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public Integer saveEmployee(EmployeeEntity employee) {
		EmployeeEntity saveemployee = employeeRepository.save(employee);
		return saveemployee.getEid();
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<EmployeeEntity> getStudent(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Integer updateEmployee(EmployeeEntity employee, Integer id) {
		EmployeeEntity exsistingemployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
		exsistingemployee.setEname(employee.getEname());
		exsistingemployee.setEdesignation(employee.getEdesignation());
		exsistingemployee.setEage(employee.getEage());
		exsistingemployee.setEmail(employee.getEmail());
		exsistingemployee.setEgender(employee.getEgender());
		employeeRepository.save(exsistingemployee);
		return exsistingemployee.getEid();
	}
	
	

}
