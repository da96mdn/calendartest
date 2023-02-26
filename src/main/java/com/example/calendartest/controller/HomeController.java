package com.example.calendartest.controller;

import com.example.calendartest.config.ContentCalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final ContentCalendarProperties properties;

	public HomeController(ContentCalendarProperties properties) {
		this.properties = properties;
	}

	@GetMapping("/home")
	public ContentCalendarProperties home() {
		return properties;
	}
}
