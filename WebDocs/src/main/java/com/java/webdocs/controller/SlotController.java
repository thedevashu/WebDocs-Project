package com.java.webdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.webdocs.entity.Slot;
import com.java.webdocs.repository.SlotRepository;
@CrossOrigin
@RestController
@RequestMapping("/slot")
public class SlotController {
	
	@Autowired
	private SlotRepository sr;
	
	@GetMapping("/getById/{sid}")
	public Slot getSlot(@PathVariable int sid) {
		return sr.getById(sid);
	}
	
	@GetMapping("/getAll")
	
	public List<Slot> getAllSlots(){
		return sr.findAll();
	}

}
