package com.test.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Manas Mohanty
 * 
 * The Class Post.
 */
@Entity
@Table(name = "POST_H")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post id. */
	@Id
	@GenericGenerator(name = "postSeq", strategy = "increment")
	@GeneratedValue(generator = "postSeq")
	@Column(name = "POST_ID" ,unique = true, nullable = false)
	private Long postId;

	/** The post title. */
	@NotNull
	@Size(min=2,max=100, message="Post Title Size must be between 2 and 100")
	@Column(name = "POST_TITLE", unique = true)
	private String postTitle;

	/** The post description. */
	@NotNull
	@Size(max = 250)
	@Column(name = "POST_DESCRIPTION")
	private String postDescription;

	/** The post content. */
	@NotNull
	@Column(name = "POST_CONTENT")
	private String postContent;

	/** The list post comments. */
	@OneToMany( fetch = FetchType.EAGER, mappedBy = "refEntityPost" , cascade = CascadeType.ALL)
	private List<PostComment> listPostComments;

	/**
	 * Instantiates a new post.
	 */
	public Post() {
		super();
	}

	/**
	 * Instantiates a new post.
	 *
	 * @param postId the post id
	 * @param postTitle the post title
	 * @param postDescription the post description
	 * @param postContent the post content
	 * @param listPostComments the list post comments
	 */
	public Post(Long postId,
			@NotNull @Size(min = 2, max = 100, message = "Post Title Size must be between 2 and 100") String postTitle,
			@NotNull @Size(max = 250) String postDescription, @NotNull String postContent,
			List<PostComment> listPostComments) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postContent = postContent;
		this.listPostComments = listPostComments;
	}





	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the post title.
	 *
	 * @return the post title
	 */
	public String getPostTitle() {
		return postTitle;
	}

	/**
	 * Sets the post title.
	 *
	 * @param postTitle the new post title
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	/**
	 * Gets the post description.
	 *
	 * @return the post description
	 */
	public String getPostDescription() {
		return postDescription;
	}

	/**
	 * Sets the post description.
	 *
	 * @param postDescription the new post description
	 */
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	/**
	 * Gets the post content.
	 *
	 * @return the post content
	 */
	public String getPostContent() {
		return postContent;
	}

	/**
	 * Sets the post content.
	 *
	 * @param postContent the new post content
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	/**
	 * Gets the list post comments.
	 *
	 * @return the list post comments
	 */
	public List<PostComment> getListPostComments() {
		return listPostComments;
	}

	/**
	 * Sets the list post comments.
	 *
	 * @param listPostComments the new list post comments
	 */
	public void setListPostComments(List<PostComment> listPostComments) {
		this.listPostComments = listPostComments;
	}
	

	

}