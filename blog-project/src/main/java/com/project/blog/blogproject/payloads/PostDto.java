package com.project.blog.blogproject.payloads;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.project.blog.blogproject.entity.Category;
import com.project.blog.blogproject.entity.User;

public class PostDto {

	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private Category category;
	
	private User user;

}
