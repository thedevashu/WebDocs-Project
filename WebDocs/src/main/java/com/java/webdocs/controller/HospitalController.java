package com.java.webdocs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.webdocs.entity.Hospital;
import com.java.webdocs.repository.HospitalRepository;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalRepository hr;
	
	@PostMapping("/add")
	public void addHospital(@RequestBody Hospital h) {
		hr.save(h);
	}
	

}
