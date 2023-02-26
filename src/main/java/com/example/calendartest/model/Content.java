package com.example.calendartest.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record Content(
	@Id Integer id,
	@NotBlank String title,
	@Column(value = "description")
	@NotBlank String desc,
	@Enumerated(EnumType.STRING) Status status,
	@Enumerated(EnumType.STRING) Type contentType,
	LocalDateTime dateCreated,
	LocalDateTime dateUpdated,
	String url) {

}
