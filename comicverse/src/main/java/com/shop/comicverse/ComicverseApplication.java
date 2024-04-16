package com.shop.comicverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shop.comicverse")
public class ComicverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicverseApplication.class, args);
	}

}
