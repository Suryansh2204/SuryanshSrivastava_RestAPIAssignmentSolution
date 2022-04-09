package com.employeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeManagement.entity.Employee;
@Service
public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee emp);
	public void deleteById(int id);
	public List<Employee> searchByFirstName(String firstName);
	public List<Employee> listAscOrder();
	public List<Employee> listDescOrder();
}
