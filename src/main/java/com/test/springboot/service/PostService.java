package com.test.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.test.springboot.model.Post;

public interface PostService {

	List<Post> getAllPosts();
	Page<Post> getAllPosts(Pageable pageable);
	Post getPost(Long postId);
	Post savePost(Post post);
	Post updatePost(Long postId, Post postRequest);
	ResponseEntity<?> deletePost(Long postId);
	Optional<Post> gePostByTitle(String postTitle);
	
}
