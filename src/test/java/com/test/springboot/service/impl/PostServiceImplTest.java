package com.test.springboot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.springboot.model.Post;
import com.test.springboot.repository.PostRepository;
import com.test.springboot.serviceimpl.PostServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PostServiceImplTest {

	@Mock
	private PostRepository postRepository;
	
	@InjectMocks
	private PostServiceImpl postServiceImpl;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllPostsList() {
		List<Post> postList = new ArrayList<>();
		Post post = new Post();
		post.setPostId(3L);
		Post post2 = new Post();
		post2.setPostId(4L);
		postList.add(post);
		postList.add(post2);
		
		when(postRepository.findAll()).thenReturn(postList);
		List<Post> result = postServiceImpl.getAllPosts();
		assertEquals(2, result.size());
		
		
	}
}
