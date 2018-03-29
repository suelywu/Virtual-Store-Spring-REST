package com.focustraining.virtualstore;

import com.focustraining.virtualstore.domain.model.entity.Client;
import com.focustraining.virtualstore.domain.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		scanBasePackages = {
		        "com.focustraining.virtualstore.domain",
                "com.focustraining.virtualstore.application",
                "com.focustraining.virtualstore.infrastructure",

        }
)
public class Application {

	public static void main(String[] args) {



		SpringApplication.run(Application.class, args);

	}

	@Bean
    public Client getClient(){
	    return new Client(1, "suely");
    }
}
