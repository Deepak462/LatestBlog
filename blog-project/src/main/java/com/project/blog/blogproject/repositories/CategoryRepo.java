package com.project.blog.blogproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.blog.blogproject.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
