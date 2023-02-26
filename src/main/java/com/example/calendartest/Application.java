package com.example.calendartest;

import com.example.calendartest.config.ContentCalendarProperties;
import com.example.calendartest.model.Content;
import com.example.calendartest.repository.ContentCollectionRepository;
import com.example.calendartest.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
