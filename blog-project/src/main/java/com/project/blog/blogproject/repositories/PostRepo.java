package com.project.blog.blogproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.blogproject.entity.Category;
import com.project.blog.blogproject.entity.Post;
import com.project.blog.blogproject.entity.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
