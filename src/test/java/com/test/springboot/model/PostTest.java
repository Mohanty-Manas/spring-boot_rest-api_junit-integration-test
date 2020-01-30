package com.test.springboot.model;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Manas Mohanty
 * 
 * The Class PostTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PostTest {

    /** The validator. */
    private static Validator validator;

    /**
     * Sets the up validator.
     */
    @BeforeClass
    public static void setUpValidator() {
    	
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    /**
     * Post title not nul.
     */
    @Test
    public void postTitleNotNul() {
        Post post = new Post(1L, null, "Post Test Description", "Post Content Test", null);

        Set<ConstraintViolation<Post>> constraintViolations = validator.validate( post );
        assertEquals( 1, constraintViolations.size() );
        assertEquals( "must not be null", constraintViolations.iterator().next().getMessage() );
    }
    
    /**
     * Post title too short.
     */
    @Test
    public void postTitleTooShort() {
        Post post = new Post(1L, "P", "Post Test Description", "Post Content Test", null);

        Set<ConstraintViolation<Post>> constraintViolations = validator.validate( post );
        assertEquals( 1, constraintViolations.size() );
        assertEquals( "Post Title Size must be between 2 and 100", constraintViolations.iterator().next().getMessage() );
    }

    /**
     * Post is valid.
     */
    @Test
    public void postIsValid() {
    	Post post = new Post(1L, "Post Title", "Post Test Description", "Post Content Test", null);

        Set<ConstraintViolation<Post>> constraintViolations = validator.validate( post );
        assertEquals( 0, constraintViolations.size() );
    }
}