package com.cursojava.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.course.entities.User;
import com.cursojava.course.repositories.UserRepository;

@Configuration // declarando a classe de configuração
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository; //acessa aos dados

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		// salvando lista no banco de dados - saveall salva uma lista no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
}
