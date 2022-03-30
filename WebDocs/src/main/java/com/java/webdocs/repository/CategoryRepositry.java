package com.java.webdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.webdocs.entity.Category;

public interface CategoryRepositry extends JpaRepository<Category, Integer> {

}
