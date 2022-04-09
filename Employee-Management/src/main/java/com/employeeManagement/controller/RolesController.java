package com.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.entity.Role;
import com.employeeManagement.repository.RoleRepository;
import com.employeeManagement.service.RolesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import io.swagger.annotations.Api;

@RestController
@Api
@RequestMapping("/roles")
public class RolesController {
	@Autowired
	RolesService rolesService;

	@GetMapping("/list")
	public List<Role> listRoles() {
		List<Role> roles = rolesService.findAll();
		return roles;
	}

	@PostMapping("/add")
	public String addRole(@RequestParam String roleName) {
		Role role = new Role().builder().name(roleName).build();
		rolesService.saveRoles(role);
		return "Role added Successfully";
	}
}
