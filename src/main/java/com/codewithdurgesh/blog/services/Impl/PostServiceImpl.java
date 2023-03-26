package com.codewithdurgesh.blog.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entity.Category;
import com.codewithdurgesh.blog.entity.Post;
import com.codewithdurgesh.blog.entity.User;
import com.codewithdurgesh.blog.exception.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.PostDto;
import com.codewithdurgesh.blog.repository.CategoryRepo;
import com.codewithdurgesh.blog.repository.PostRepo;
import com.codewithdurgesh.blog.repository.UserRepo;
import com.codewithdurgesh.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "category Id", categoryId));

		Post post = this.mapper.map(postDto, Post.class);

		post.setImageName("default.png");
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);

		Post createdPost = this.postRepo.save(post);

		return this.mapper.map(createdPost, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		List<Post> posts = this.postRepo.findByUser(user);

		List<PostDto> postDto = posts.stream().map((post) -> mapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postDto;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "category id", categoryId));

		List<Post> posts = this.postRepo.findByCategory(category);

		List<PostDto> postDto = posts.stream().map((post) -> mapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize) {
//		
//		int pageNumber=1;
//		int pageSize=5;
//		
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);

		Page<Post> findAllPage = this.postRepo.findAll(pageRequest);
		List<Post> posts = findAllPage.getContent();

		List<PostDto> postDto = posts.stream().map((post) -> mapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));

		return mapper.map(post, PostDto.class);
	}

	@Override
	public void deletePostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "PostId", postId));

		this.postRepo.delete(post);

	}

	/**
	 *
	 */
	@Override
	public PostDto updatePostById(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());

		Post updatedPost = this.postRepo.save(post);

		return this.mapper.map(updatedPost, PostDto.class);
	}

}
