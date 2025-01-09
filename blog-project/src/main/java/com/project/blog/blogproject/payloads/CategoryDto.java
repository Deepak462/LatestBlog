package com.project.blog.blogproject.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;

	@NotEmpty
	@Size(min=4,message="categoryTitle must be of minimum 4 charater")
	private String categoryTitle;

	@NotEmpty
	@Size(min=4,message="categoryDesc must be of minimum 4 charater")
	private String categoryDesc;

}
