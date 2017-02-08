package com.example;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.domain.UserRole;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

@SpringBootApplication
public class SecurityexampleApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SecurityexampleApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		User user = new User();
		user.setUsername("zach");
		user.setPassword("password");
		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setName("ADMIN");
		userRoles.add(new UserRole(user,role));
		userService.createUser(user,userRoles);

	}
}
