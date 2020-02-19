package com.hcl.ecom.ECommercePoc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hcl.ecom.ECommercePoc.model.User;
import com.hcl.ecom.ECommercePoc.repository.UserRepository;

@SpringBootApplication
public class ECommercePocApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ECommercePocApplication.class, args);
	}
	
	@Bean
	PasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}
	

	@Override
	public void run(String... args) throws Exception {
		if (this.userRepository.findByUsername("praveen") == null) {
			User user = new User("praveen verma", "praveen", passwordEncoder.encode("praveen123"),
					Arrays.asList("ADMIN"));

			this.userRepository.save(user);
		}
	}

}
