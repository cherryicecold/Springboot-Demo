package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("hello Karan this is spring boot");
	}

	@GetMapping
	public String hello(){
		return "Hello Karan,this is Spring boot.Welcome to the mission space.";
	}

	@GetMapping("/user")
	public List<Student> users(){
		return List.of(new Student(1L,"Karan","karanpreet2494@gmail.com", LocalDate.of(2000, Month.FEBRUARY,24),21));
	}

}
