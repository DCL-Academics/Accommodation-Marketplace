package com.dcl.accommodate;

import com.dcl.accommodate.enums.UserRole;
import com.dcl.accommodate.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Duration;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class AccommodationMarketplaceApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(AccommodationMarketplaceApplication.class, args);
    }
}
