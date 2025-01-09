package com.project.blog.blogproject.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.sun.xml.bind.v2.TODO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.blogproject.entity.User;
import com.project.blog.blogproject.exceptions.ResourceNotFoundException;
import com.project.blog.blogproject.payloads.UserDto;
import com.project.blog.blogproject.repositories.UserRepo;
import com.project.blog.blogproject.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private ModelMapper mp;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.UserDtoToUser(userDto);
		userRepo.save(user);
		return userDto;
	}


	@Override
	public UserDto updateUser(UserDto userDto, Integer user_id) {

		User user=(User)userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User","id",user_id));
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		userRepo.save(user);

		// in response body in postman we are getting all field values updated
		// but id value is showing 0 but it is updated successfully so setting id here
//		like this {
//			        "id": 0,
//					"name": "someone",
//					"email": "HAH@gmail.com",
//					"password": "nhi batara",
//					"about": "ye bhi koi to h"
//		}
		userDto.setId(user_id);
		// after adding above line it is showing correct id
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer user_id) {

		User user=userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User","id",user_id));
		
		return this.UserToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> userlist=userRepo.findAll();
		List<UserDto> userDtos=userlist.stream().map(user->this.UserToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer user_id) {

		userRepo.deleteById(user_id);
	}
	
	public User UserDtoToUser(UserDto userDto) {
		
		User user=this.mp.map(userDto, User.class);
		
//		User user=new User();
//		user.setId(user.getId());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
		return user;
	}

	public UserDto UserToUserDto(User user) {
		
		UserDto userdto=this.mp.map(user, UserDto.class);
		
//		UserDto userdto=new UserDto();
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setPassword(user.getPassword());
//		userdto.setAbout(user.getAbout());
//		userdto.setEmail(user.getEmail());
		return userdto;
	}
}
