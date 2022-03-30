package com.java.webdocs.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.webdocs.entity.Category;
import com.java.webdocs.entity.Doctor;
import com.java.webdocs.entity.Feedback;
import com.java.webdocs.entity.Hospital;
import com.java.webdocs.entity.Patient;
import com.java.webdocs.repository.CategoryRepositry;
import com.java.webdocs.repository.DoctorRepository;
import com.java.webdocs.repository.PatientRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorRepository dr;
	@Autowired
	private PatientRepository pr;
	@Autowired
	private CategoryRepositry cr;
	
	@GetMapping("/add")
	public void addDoc(@RequestBody Doctor d)
	{
		dr.save(d);
		//Date  date = Date.valueOf("2020-2-2");
		
//		pr.save(p);
//		
//		Doctor d = new Doctor();
//		d.setDoctor_Fees(100);
//		d.setDoctor_Name("doctor");
//		d.setCategory(null);
//		dao.addDoctor(d);
//	
//		Patient p = new Patient( );
//		p.setPatient_Name("name");
//		p.setPatient_DOB(date);
//		p.setAppointments(null);
//		p.setFeedbacks(null);
//		p.setPatient_Email("email");
//		p.setPatient_Photo(null);
//		p.setPatient_Gender("m");
//		p.setPatient_Username("uname");
//		p.setPatient_Password("pas");
//		pr.save(p);
//		System.out.println("Doctor added successfully");
	}
}
