package com.theyardapp.authmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theyardapp.authmicroservice.user.UserRepository;

@SpringBootApplication
public class AuthMicroserviceApplication {

	@Autowired
	UserRepository userRepository;

	

	public static void main(String[] args) {
		SpringApplication.run(AuthMicroserviceApplication.class, args);
	}

}
