package com.example.calendartest.repository;

import com.example.calendartest.model.Content;
import com.example.calendartest.model.Status;
import com.example.calendartest.model.Type;
import com.helger.commons.annotation.Singleton;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
	private final List<Content> contents = new ArrayList<>();

	public ContentCollectionRepository() {
		contents.add(new Content(null, "First Content", "Desc", Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Second Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Third Content", "Desc",Status.COMPLETED, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Fourth Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Fifth Content", "Desc",Status.IDEA, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Sixth Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Seventh Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Eighth Content", "Desc",Status.IDEA, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Ninth Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Tenth Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Eleventh Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Twelfth Content", "Desc",Status.COMPLETED, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Thirteenth Content", "Desc",Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
		contents.add(new Content(null, "Fourteenth Content", "Desc",Status.PUBLISHED, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "https://www.google.com"));
	}


	public List<Content> findAll() {
		return contents;
	}

	public Optional <Content> findById(Integer id) {
	  return contents.stream().filter(c -> c.id().equals(id)).findFirst();
	}

	public void save(final Content content) {
		delete(content.id());
		contents.add(content);
	}

	public boolean existsById(final Integer id) {
		return contents.stream().filter(c -> c.id().equals(id)).count() == 1;
	}

	public void delete(final Integer id) {
		contents.removeIf(c -> c.id().equals(id));
	}
}
