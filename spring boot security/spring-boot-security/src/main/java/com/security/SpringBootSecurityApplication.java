package com.security;

import com.security.models.User;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.PrivateKey;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setEmail("adarsh@gmail.com");
		user.setUsername("Adarsh");
		user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
		user.setRole("Role_Admin");
		this.userRepository.save(user);

		User user1=new User();
		user1.setEmail("ravi@gmail.com");
		user1.setUsername("Ravi");
		user1.setPassword(this.bCryptPasswordEncoder.encode("123456"));
		user1.setRole("Role_Normal");
		this.userRepository.save(user1);

	}
}
