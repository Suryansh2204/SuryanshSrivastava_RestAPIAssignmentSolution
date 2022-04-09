package com.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeeManagement.entity.Role;
import com.employeeManagement.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
