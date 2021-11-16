package com.careerdevs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping("/")
	public String rootRoute () {
		return "Welcome Home!";
	}

	@GetMapping("/apod")
	public APOD apodInfo (RestTemplate restTemplate) {
		String URL = "https://api.nasa.gov/planetary/apod?api_key=oEwTsgs7ykr7HFAKqByrYMycGgsiQPdheYoVaZNR";

		APOD apod = restTemplate.getForObject(URL, APOD.class);

		return apod;
	}

}
