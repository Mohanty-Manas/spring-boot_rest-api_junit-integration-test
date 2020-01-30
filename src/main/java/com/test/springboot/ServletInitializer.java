package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Manas Mohanty
 * 
 * The Class ServletInitializer.
 */
@Import({ ApplicationConfiguration.class})
@SpringBootApplication (scanBasePackages = "com.test.springboot")
public class ServletInitializer {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServletInitializer.class, args);
    }

}
