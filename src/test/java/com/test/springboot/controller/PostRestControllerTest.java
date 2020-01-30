package com.test.springboot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.test.springboot.model.Post;
import com.test.springboot.service.PostService;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class PostRestControllerTest {

	private static final Long ID = 1L;
	private static final List<Post> postList = null;
	private static final String ENTITY_URI = "/test-api/";
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	@Mock
	private PostService postService;
	
	@InjectMocks
	private PostRestController postRestController;
	
	@Before
	public void setup() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppContext).build();
	}
	
	@Test
	public void verifyGetAllPostsList() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get(ENTITY_URI+"posts").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").exists())
		.andDo(print());
	}
	
}
