package com.levelup.app;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.levelup.app.models.Comuna;
import com.levelup.app.models.Role;
import com.levelup.app.models.User;
import com.levelup.app.repositories.ComunaRepository;
import com.levelup.app.repositories.RoleRepository;
import com.levelup.app.repositories.UserRepository;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
		UserRepository userRepository,
		PasswordEncoder encoder,
		ComunaRepository comunaRepository,
		RoleRepository roleRepository
	) {
		return args ->{

			Comuna comuna = comunaRepository.findById(1L).orElseThrow();
			Role role = roleRepository.findById(3L).orElseThrow();

			User user = new User("21340282K", "admin", "admin", "admin@gmail.com", 
			LocalDate.of(1990, 1, 1), encoder.encode("admin"),"Cerrillos #213", comuna, role);

			userRepository.save(user);			
			
		};
	}

}
