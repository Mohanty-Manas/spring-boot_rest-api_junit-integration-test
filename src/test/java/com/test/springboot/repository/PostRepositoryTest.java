package com.test.springboot.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.springboot.model.Post;
import com.test.springboot.model.PostComment;

/**
 * @author Manas Mohanty
 * 
 * The Class PostRepositoryTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
@ActiveProfiles("test") // if active profile not given in application.properties file
public class PostRepositoryTest {

	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/** The post repository. */
	@Autowired
	private PostRepository postRepository;

	/**
	 * Test find by post title.
	 */
	@Test
	public void testFindByPostTitle() {

		Post postEntity = new Post();
		postEntity.setPostTitle("Post Title Test");
		postEntity.setPostDescription("Post Description Test");
		postEntity.setPostContent("Post Content Test");

		PostComment postCommentEntity1 = new PostComment();
		postCommentEntity1.setPostComment("This is a post comment");
		postCommentEntity1.setRefEntityPost(postEntity);

		PostComment postCommentEntity2 = new PostComment();
		postCommentEntity2.setPostComment("This is another post comment");
		postCommentEntity2.setRefEntityPost(postEntity);

		// postEntity.setListPostComments(Arrays.asList(postCommentEntity1,
		// postCommentEntity2));

		entityManager.persist(postEntity);
		Optional<Post> post = postRepository.findByPostTitle("Post Title Test");
		assertEquals("Post Title Test", post.get().getPostTitle());
	}
}