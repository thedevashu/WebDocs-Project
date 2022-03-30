package com.java.webdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.webdocs.entity.Feedback;

public interface FeedbackRepositry extends JpaRepository<Feedback, Integer> {

}
