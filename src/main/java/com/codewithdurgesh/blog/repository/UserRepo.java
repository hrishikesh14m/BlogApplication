package com.codewithdurgesh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithdurgesh.blog.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
