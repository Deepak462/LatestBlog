package com.project.blog.blogproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.blog.blogproject.payloads.UserDto;


public interface UserService {

	//here we will not give or expose user entity into service so we will create another
	//class UserDto with same property in payloads package

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer user_id);
	UserDto getUserById(Integer user_id);
	List<UserDto> getAllUsers();
	void deleteUser(Integer user_id);
	
}
