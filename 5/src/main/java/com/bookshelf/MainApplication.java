package com.bookshelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * the main program, that starts the server
 */
@SpringBootApplication
public class MainApplication {
	/**
	 * main program
	 * @param args not needed actually, but it's a sample
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}