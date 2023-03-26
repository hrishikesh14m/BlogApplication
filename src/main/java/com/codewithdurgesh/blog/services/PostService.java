package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getAllPosts(Integer pageNumber ,Integer pageSize);
	
	PostDto getPostById(Integer postId);

	void deletePostById(Integer postId);
	
	PostDto updatePostById(PostDto postDto , Integer postId);
}
