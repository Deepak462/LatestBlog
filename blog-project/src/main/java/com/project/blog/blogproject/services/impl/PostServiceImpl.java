package com.project.blog.blogproject.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.blogproject.entity.Category;
import com.project.blog.blogproject.entity.Post;
import com.project.blog.blogproject.entity.User;
import com.project.blog.blogproject.exceptions.ResourceNotFoundException;
import com.project.blog.blogproject.payloads.PostDto;
import com.project.blog.blogproject.repositories.CategoryRepo;
import com.project.blog.blogproject.repositories.PostRepo;
import com.project.blog.blogproject.repositories.UserRepo;
import com.project.blog.blogproject.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo catRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
		Category category=this.catRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category id",categoryId));
		
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");  // here we set these field here but also don't need to do this as we are already getting data from user
		post.setAddedDate(new Date());
		
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
