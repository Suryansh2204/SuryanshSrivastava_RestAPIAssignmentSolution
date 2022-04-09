package com.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.entity.Role;
import com.employeeManagement.repository.RoleRepository;

@Service
public class RolesServiceImpl implements RolesService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void saveRoles(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		List<Role> roles=roleRepository.findAll();
		return roles;
	}

	@Override
	public void deleteById(Integer id) {
		roleRepository.deleteById(id);
		
	}

	@Override
	public Role findById(Integer id) {
		Role role=roleRepository.findById(id).get();
		return role;
	}

	

}
