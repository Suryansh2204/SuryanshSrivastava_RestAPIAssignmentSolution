package com.employeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeManagement.entity.Employee;
import com.employeeManagement.entity.Role;

@Service
public interface RolesService {
	public void saveRoles(Role role);
	public List<Role> findAll();
	public void deleteById(Integer id);
	public Role findById(Integer id);
}
