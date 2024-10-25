package com.project.blog.blogproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.blogproject.payloads.ApiResponse;
import com.project.blog.blogproject.payloads.CategoryDto;
import com.project.blog.blogproject.services.CategoryService;

@RestController
@RequestMapping("/api/catogories")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto catDto){
		CategoryDto createdCat=this.catService.createCategory(catDto);
		return new ResponseEntity<>(createdCat,HttpStatus.CREATED);			//when you want to send both and response code and use responseentity
	}
	
	@PutMapping("/{cat_id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto catDto,@PathVariable("cat_id") Integer catId){
		CategoryDto updatedCat=this.catService.updateCategory(catDto,catId);
		return ResponseEntity.ok(updatedCat);
	}
	
	@DeleteMapping("/{cat_id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("cat_id") Integer cat_id){
		this.catService.deleteCategory(cat_id);
		return new ResponseEntity(new ApiResponse("Category Deleted successfully",true),HttpStatus.GONE);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
	return ResponseEntity.ok(this.catService.getCategories());
		
	}
	
	@GetMapping("/{cat_id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer cat_id){
	return ResponseEntity.ok(this.catService.getCategory(cat_id));
		
	}

}
