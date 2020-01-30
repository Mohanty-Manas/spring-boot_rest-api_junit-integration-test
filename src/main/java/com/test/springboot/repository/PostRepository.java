package com.test.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.springboot.model.Post;

/**
 * @author Manas Mohanty
 * 
 * The Interface PostRepository.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	/**
	 * Find by post title.
	 *
	 * @param string the string
	 * @return the optional
	 */
	Optional<Post> findByPostTitle(String string);

}
