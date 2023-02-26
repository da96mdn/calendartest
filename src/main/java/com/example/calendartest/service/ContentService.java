package com.example.calendartest.service;

import com.example.calendartest.controller.ContentController;
import com.example.calendartest.model.Content;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ContentService {
	private final RestTemplate template;
	private final WebClient client;
	private final ContentController contentController;

	private final ObjectMapper jsonMapper =  new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	@Autowired
	 public ContentService(RestTemplateBuilder rtBuilder, WebClient.Builder wcBuilder, ContentController contentController) {
		template = rtBuilder.build();
		client = wcBuilder.baseUrl("http://localhost:8080").build();
		this.contentController = contentController;
	}

	public String getContents() {
		String url = "http://localhost:8080/api/content";
		return template.getForObject(url, String.class);
	}

	public String getPrettyContents() {
		String strPrettyContent = "";
		try {
			Object json = jsonMapper.readValue(getContents(), Object.class);
			strPrettyContent = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		} catch(JsonProcessingException ignore) {
		}
		return strPrettyContent;
	}
}
