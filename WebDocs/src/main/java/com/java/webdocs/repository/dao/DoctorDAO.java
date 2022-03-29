package com.java.webdocs.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webdocs.entity.Doctor;
import com.java.webdocs.repository.DoctorRepository;

@Service
public class DoctorDAO {

	@Autowired
	private DoctorRepository repository;
	
	public void addDoctor(Doctor doctor)
	{
		
		repository.save(doctor);
		System.out.println("In doctor dao");
	}
}
