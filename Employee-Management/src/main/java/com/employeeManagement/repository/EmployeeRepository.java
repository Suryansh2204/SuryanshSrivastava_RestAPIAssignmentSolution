package com.employeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{
	List<Employee> findByFirstName(String firstName);
}
