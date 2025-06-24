package com.example.RESTAPI;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {

		Dotenv dotenv= Dotenv.configure().load(); //Load the environment variable from .env file
		dotenv.entries().forEach(entry->System.setProperty(entry.getKey(),entry.getValue())); //get the properties from environment variable and set them
		SpringApplication.run(RestapiApplication.class, args);
	}

}
