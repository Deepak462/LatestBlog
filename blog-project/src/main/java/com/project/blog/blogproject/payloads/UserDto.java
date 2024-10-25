package com.project.blog.blogproject.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min=4,message="Usename must be of minimum 4 charater")
	private String name;
	
	@Email(message="Email formart is not valid")
	private String email;
	
	@NotNull
	@Size(min=3,max=10,message="Passworn must be min 3 and max 10 Character")
	private String password;
	
	@NotNull
	private String about;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
}
