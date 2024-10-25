package com.project.blog.blogproject.services;

import java.util.List;

import com.project.blog.blogproject.payloads.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	//we could also add user Id and category id from postDto by adding those fields in postDto
	PostDto updatePost(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllPosts();
	PostDto getPostById(Integer postId);
	List<PostDto> getPostsByCategory(Integer categoryId);
	List<PostDto> getPostsByUser(Integer userId);
	List<PostDto> searchPosts(String keyword);

}
