package com.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.employeeManagement.entity.Employee;
import com.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public List<Employee> findAll() {
		List<Employee> emp=empRepository.findAll();
		return emp;
	}

	@Override
	public Employee findById(int id) {
		Employee emp=empRepository.findById(id).get();
		return emp;
	}

	@Override
	public void save(Employee emp) {
		empRepository.save(emp);		
	}

	@Override
	public void deleteById(int id) {
		empRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		List<Employee> employees=empRepository.findByFirstName(firstName);
		return employees;
	}

	@Override
	public List<Employee> listAscOrder() {
		List<Employee> emp=empRepository.findAll(Sort.by(Direction.ASC,"firstName"));
		return emp;
	}

	@Override
	public List<Employee> listDescOrder() {
		List<Employee> emp=empRepository.findAll(Sort.by(Direction.DESC,"firstName"));
		return emp;
	}
}
