package com.test.springboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Manas Mohanty
 * 
 * The Class PostComment.
 */
@Entity
@Table(name = "POST_COMMENT_D")
@NamedQuery(name = "PostComment.findAll", query = "SELECT p FROM PostComment p")
public class PostComment implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post comment id. */
	@Id
	@GenericGenerator(name = "postCommentSeq", strategy = "increment")
	@GeneratedValue(generator = "postCommentSeq")
	@Column(name = "POST_COMMENT_ID", unique = true, nullable = false)
	private Long postCommentId;

	/** The post comment. */
	@NotNull
	@Column(name = "POST_COMMENT_DESC")
	private String postComment;

	/** The ref entity post. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "POST_ID", nullable = true)
	private Post refEntityPost;

	/**
	 * Instantiates a new post comment.
	 */
	public PostComment() {
		super();
	}

	/**
	 * Instantiates a new post comment.
	 *
	 * @param postCommentId
	 *            the post comment id
	 * @param postComment
	 *            the post comment
	 * @param refEntityPost
	 *            the ref entity post
	 */
	public PostComment(Long postCommentId, String postComment, Post refEntityPost) {
		super();
		this.postCommentId = postCommentId;
		this.postComment = postComment;
		this.refEntityPost = refEntityPost;
	}

	/**
	 * Gets the post comment id.
	 *
	 * @return the post comment id
	 */
	public Long getPostCommentId() {
		return postCommentId;
	}

	/**
	 * Sets the post comment id.
	 *
	 * @param postCommentId
	 *            the new post comment id
	 */
	public void setPostCommentId(Long postCommentId) {
		this.postCommentId = postCommentId;
	}

	/**
	 * Gets the post comment.
	 *
	 * @return the post comment
	 */
	public String getPostComment() {
		return postComment;
	}

	/**
	 * Sets the post comment.
	 *
	 * @param postComment
	 *            the new post comment
	 */
	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}

	/**
	 * Gets the ref entity post.
	 *
	 * @return the ref entity post
	 */
	public Post getRefEntityPost() {
		return refEntityPost;
	}

	/**
	 * Sets the ref entity post.
	 *
	 * @param refEntityPost
	 *            the new ref entity post
	 */
	public void setRefEntityPost(Post refEntityPost) {
		this.refEntityPost = refEntityPost;
	}

}