package com.example.calendartest.repository;

import com.example.calendartest.model.Content;
import com.example.calendartest.model.Status;
import com.example.calendartest.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {
	private final JdbcTemplate jdbcTemplate;

	public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static Content mapRow(ResultSet rs, int rowNum) throws SQLException	{
		return new Content(
			rs.getInt("id"),
			rs.getString("title"),
			rs.getString("desc"),
			Status.valueOf(rs.getString("status")),
			Type.valueOf(rs.getString("content_type")),
			rs.getTimestamp("date_created").toLocalDateTime(),
			rs.getTimestamp("date_updated").toLocalDateTime(),
			rs.getString("url")
		);
	}

	public List<Content> getAllContent() {
		return jdbcTemplate.query("SELECT * FROM content", ContentJdbcTemplateRepository::mapRow);
	}

	public void createContent(String title, String desc, Status status, Type contentType, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
		jdbcTemplate.update("INSERT INTO content (title, desc, status, content_type, date_created, date_updated, url) VALUES (?, ?, ?, ?, ?, ?, ?)", title, desc, status, contentType, dateCreated, dateUpdated, url);
	}

	public void updateContent(Integer id, String title, String desc, Status status, Type contentType, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
		jdbcTemplate.update("UPDATE content SET title = ?, desc = ?, status = ?, content_type = ?, date_created = ?, date_updated = ?, url = ? WHERE id = ?", title, desc, status, contentType, dateCreated, dateUpdated, url, id);
	}

	public void deleteContent(Integer id) {
		jdbcTemplate.update("DELETE FROM content WHERE id = ?", id);
	}

	public Content getContentById(Integer id) {
		return jdbcTemplate.queryForObject("SELECT * FROM content WHERE id = ?", ContentJdbcTemplateRepository::mapRow, id);
	}

}
