package com.project.blog.blogproject.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {

	String message;
	boolean success;
	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

}
