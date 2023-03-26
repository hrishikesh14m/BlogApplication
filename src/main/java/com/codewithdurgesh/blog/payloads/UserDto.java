package com.codewithdurgesh.blog.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Integer id;
	
	@NotEmpty
	@Size(min = 4,message = "username must have atleast 4 char!!")
	private String name;
	
	@NotEmpty
	@Email(message = "email is not valid please enter valid email address!!")
	private String email;
	
	@NotEmpty
	@Size(min = 3 ,max = 10 ,message = "password should be minimum 3 length and maximum 4 length!!")
	private String password;
	
	@NotEmpty
	private String about;
	
}
