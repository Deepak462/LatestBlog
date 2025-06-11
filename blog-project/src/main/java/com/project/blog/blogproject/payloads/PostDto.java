package com.project.blog.blogproject.payloads;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.project.blog.blogproject.entity.Category;
import com.project.blog.blogproject.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;

}
