package com.codewithdurgesh.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

	private Integer categoryId;

	@NotEmpty
	@Size(min=4 , message = "Min size of category title is 4.")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min =10 , message = "Min size of category description is 10.")
	private String categoryDescription;
	
}
