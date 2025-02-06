package com.filehiderproject.file_hider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Views.WelComePage;

@SpringBootApplication
public class FileHiderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileHiderApplication.class, args);

		// WelComePage welComePage = new WelComePage();

		do {
			WelComePage.welcomeScreen();

		} while (true);
	}

}
