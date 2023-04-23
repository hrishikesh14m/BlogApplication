package com.codewithdurgesh.blog.services;

import java.util.List;

import com.codewithdurgesh.blog.payloads.PostDto;
import com.codewithdurgesh.blog.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	List<PostDto> getPostByUser(Integer userId);

	List<PostDto> getPostByCategory(Integer categoryId);

	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Integer postId);

	void deletePostById(Integer postId);

	PostDto updatePostById(PostDto postDto, Integer postId);

	List<PostDto> searchPost(String keyword);
}
