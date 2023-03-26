package com.codewithdurgesh.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithdurgesh.blog.repository.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String name =this.userRepo.getClass().getName();
		String packageName=this.userRepo.getClass().getPackageName();		
		
		System.out.println("Class Name : "+name);
		System.out.println("Package Name : "+ packageName);
		
		
	}
}
