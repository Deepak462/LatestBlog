package com.project.blog.blogproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.blogproject.payloads.ApiResponse;
import com.project.blog.blogproject.payloads.UserDto;
import com.project.blog.blogproject.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUser=this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("user_id") Integer uid){
		UserDto updatedUser=this.userService.updateUser(userDto,uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{user_id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("user_id") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity(new ApiResponse("User Deleted successfully",true),HttpStatus.GONE);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
	return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
	return ResponseEntity.ok(this.userService.getUserById(userId));
		
	}
}
