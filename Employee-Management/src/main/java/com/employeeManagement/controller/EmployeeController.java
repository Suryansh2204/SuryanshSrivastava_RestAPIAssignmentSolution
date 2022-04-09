package com.employeeManagement.controller;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employeeManagement.entity.Employee;
import com.employeeManagement.repository.EmployeeRepository;
import com.employeeManagement.service.EmployeeService;
import com.google.gson.Gson;

import io.swagger.annotations.Api;

//for 403
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@Api
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/list")
	public List<Employee> listEmployeess() {
		List<Employee> employees = employeeService.findAll();
		return employees;
	}

	@GetMapping("/listAscOrder")
	public List<Employee> listInASC() {
		List<Employee> employees = employeeService.listAscOrder();
		return employees;
	}
	
	@GetMapping("/listDescOrder")
	public List<Employee> listInDSC() {
		List<Employee> employees = employeeService.listDescOrder();
		return employees;
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestParam String fname, @RequestParam String lName, @RequestParam String email) {
		Employee emp = new Employee().builder().firstName(fname).lastName(lName).email(email).build();
		employeeService.save(emp);
		return "Employee Added Successfully";
	}


	@PutMapping("/update")
	public Employee update(String json) {
		Gson gson = new Gson();
		Employee employee = gson.fromJson(json, Employee.class);
		Optional<Employee> updateEmployee=employeeRepository.findById(employee.getId());
		if(!(updateEmployee.isPresent()))
		{
			return null;
		}
		
		employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		employeeService.deleteById(id);
		return String.format("Deleted Employee id - %d", id);
	}

	@GetMapping("/searchByFirstName")
	public List<Employee> search(@RequestParam String name) {
		if (name.trim().isEmpty()) {
			return null;
		} else {
			List<Employee> employees = employeeService.searchByFirstName(name);
			return employees;
		}

	}

	@GetMapping("/searchById")
	public Employee search(@RequestParam int id) {
		Employee emp = employeeService.findById(id);
		return emp;
	}



}
