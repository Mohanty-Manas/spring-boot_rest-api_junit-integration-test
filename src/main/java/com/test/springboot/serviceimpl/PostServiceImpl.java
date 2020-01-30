package com.test.springboot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.springboot.exception.ResourceNotFoundException;
import com.test.springboot.model.Post;
import com.test.springboot.repository.PostRepository;
import com.test.springboot.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;
	
	public Page<Post> getAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	
	@Override
	public Post getPost(Long postId) {
		Optional<Post> post = postRepository.findById(postId);

		if (!post.isPresent())
			throw new ResourceNotFoundException("PostId " + postId + " not found");
		return post.get();
	}

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(Long postId, Post postRequest) {
		return postRepository.findById(postId).map(post -> {
			post.setPostTitle(postRequest.getPostTitle());
			post.setPostDescription(postRequest.getPostDescription());
			post.setPostContent(postRequest.getPostDescription());
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}

	@Override
	public ResponseEntity<?> deletePost(Long postId) {
		
		return postRepository.findById(postId).map(post -> {
			try {
				postRepository.delete(post);
				return  ResponseEntity
			            .status(HttpStatus.OK)
			            .body("Success");
			}
			catch(Exception e) {
		        return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("Error Message");
		    }
			
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}

	@Override
	public Optional<Post> gePostByTitle(String postTitle) {
		return postRepository.findByPostTitle(postTitle);
		
	}

	
	
}
