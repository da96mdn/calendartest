package com.example.calendartest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties(String welcomeMessage, String aboutMessage) {
}
