package com.example.my_book_manager_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyBookManagerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBookManagerSystemApplication.class, args);
	}
  @GetMapping
	public String hello(){
		return "hello";
	}
}
