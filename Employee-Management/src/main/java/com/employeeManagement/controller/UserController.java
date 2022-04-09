package com.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.entity.Role;
import com.employeeManagement.entity.User;
import com.employeeManagement.service.RolesService;
import com.employeeManagement.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import io.swagger.annotations.Api;

@RestController
@Api
@RequestMapping("/users")
public class UserController {
	@Autowired 
	UserService userService;
	
	@Autowired
	RolesService roleService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	


	@PostMapping("/addUsers")
	public String addUsers(@RequestParam String username, @RequestParam String password,  @RequestParam String role)
	{
		User user=new User().builder().active(true).password(password).roles(role).userName(username).build();//(passwordEncoder.encode(password)).build();
		userService.save(user);
		return "User added Successfully";
	}
}
