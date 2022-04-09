package com.employeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeManagement.entity.User;

@Service
public interface UserService {
	public void save(User user);
}
