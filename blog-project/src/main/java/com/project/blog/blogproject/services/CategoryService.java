package com.project.blog.blogproject.services;

import java.util.List;

import com.project.blog.blogproject.payloads.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	CategoryDto getCategory(Integer categoryId);
	List<CategoryDto> getCategories();
	void deleteCategory(Integer categoryId);

}
