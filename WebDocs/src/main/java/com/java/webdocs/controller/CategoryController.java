package com.java.webdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.webdocs.entity.Category;
import com.java.webdocs.repository.CategoryRepositry;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepositry cr;
	
	@GetMapping("/getAll")
	public List<Category> getAllCategorys(){
		return cr.findAll();
	}
	
	@PostMapping("/add")
	public void addCategory(@RequestBody Category c) {
		cr.save(c);
	}
}
