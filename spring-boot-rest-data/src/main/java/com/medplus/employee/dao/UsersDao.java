package com.medplus.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medplus.employee.entities.Users;

public interface UsersDao extends JpaRepository<Users, String>{

}
