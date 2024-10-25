package com.project.blog.blogproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.blogproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
