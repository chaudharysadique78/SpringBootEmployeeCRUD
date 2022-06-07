package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;

public interface IEmployeeService {
	
	public Integer saveEmployee(EmployeeEntity employee);
	
	public List<EmployeeEntity> getAllEmployee();
	
	public Optional<EmployeeEntity> getStudent(Integer id);
	
	public void deleteEmployee(Integer id);
	
	public Integer updateEmployee(EmployeeEntity employee,Integer id);

}
