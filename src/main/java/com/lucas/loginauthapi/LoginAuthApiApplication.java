package com.lucas.loginauthapi;

import com.lucas.loginauthapi.domain.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class LoginAuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAuthApiApplication.class, args);
	}
}
