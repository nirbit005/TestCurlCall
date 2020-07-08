package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class TestCurlCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCurlCallApplication.class, args);
		System.out.println("Without For Loop - " + args[0].toString());
		for(String arg:args) {
            System.out.println("In For Loop - " + arg);
            
       // java -jar ./build/libs/TestCurlCall-0.0.1-SNAPSHOT.jar  Nirmal Kumar
       // Without For Loop - Nirmal
       // In For Loop - Nirmal
       // In For Loop - Kumar     
      }
	}

}
