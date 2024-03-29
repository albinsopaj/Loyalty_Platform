package it.unicam.cs.ids.loyaltyPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class LoyaltyPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyPlatformApplication.class, args);
	}

}
