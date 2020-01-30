package com.test.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.model.Post;
import com.test.springboot.service.PostService;

/**
 * @author Manas Mohanty
 * 
 * The Class PostRestController.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/test-api")
public class PostRestController {

	/** The post repository. */
	@Autowired
	PostService postservice;

	/**
	 * Gets the all posts.
	 *
	 * @param pageable the pageable
	 * @return the all posts
	 */
	@GetMapping("/posts-pageable")
	public Page<Post> getAllPostsPageable(Pageable pageable) {
		return postservice.getAllPosts(pageable);
	}

	
	@GetMapping("/posts")
	public List<Post> getAllPostsList() {
		return postservice.getAllPosts();
	}
	
	/**
	 * Gets the post.
	 *
	 * @param postId the post id
	 * @return the post
	 */
	@GetMapping("/post/{postId}")
	public Post getPost(@PathVariable Long postId) {
		return postservice.getPost(postId);
	}
	
	@GetMapping("/post/post-title/{postTitle}")
	public Post gePostByTitle(@PathVariable String postTitle) {
		Optional<Post> post = postservice.gePostByTitle(postTitle);
		if (post.isPresent()) {   
			return post.get();
        } else  
        	return null;
	}
	

	/**
	 * Creates the post.
	 *
	 * @param post the post
	 * @return the post
	 */
	@PostMapping("/post")
	public Post createPost(@Valid @RequestBody Post post) {
		return postservice.savePost(post);
	}

	/**
	 * Update post.
	 *
	 * @param postId the post id
	 * @param postRequest the post request
	 * @return the post
	 */
	@PutMapping("/post/{postId}")
	public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
		return postservice.updatePost(postId, postRequest);
	}

	/**
	 * Delete post.
	 *
	 * @param postId the post id
	 * @return the response entity
	 */
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId) {
		return postservice.deletePost(postId);
	}

}
