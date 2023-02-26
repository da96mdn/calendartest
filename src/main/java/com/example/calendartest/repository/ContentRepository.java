package com.example.calendartest.repository;

import com.example.calendartest.model.Content;
import com.example.calendartest.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ContentRepository extends CrudRepository<Content, Integer> {
	List<Content> findAllByTitleContains(String keyword);

	@Query("""
			SELECT *
			FROM Content c
			WHERE c.status = :status
			""")
	List<Content> listByStatus(@Param("status") Status status);
}
