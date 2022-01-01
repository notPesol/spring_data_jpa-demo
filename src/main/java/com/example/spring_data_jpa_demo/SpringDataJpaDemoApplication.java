package com.example.spring_data_jpa_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SpringDataJpaDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringDataJpaDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(PersonRepository repository) {
		return args -> {
			repository.save(new Person("John", "Crown"));
			repository.save(new Person("Hall", "Jackson"));
			repository.save(new Person("Jimmy", "Great"));
			repository.save(new Person("Baby", "Vincent"));
			repository.save(new Person("Zara", "Obama"));

			logger.info("find Person with findAll()");
			logger.info("---------------------------");

			List<Person> persons = (List<Person>) repository.findAll();
			for (Person p:
				 persons) {
				logger.info(p.toString());
			}
			logger.info("---------------------------");
		};
	}
}
