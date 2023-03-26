package com.codewithdurgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
