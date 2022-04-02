package com.java.webdocs.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.java.webdocs.repository.HospitalRepository;
import com.java.webdocs.repository.PatientRepository;
@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorRepository dr;
	@Autowired
	private HospitalRepository hr;
	@Autowired
	private LoginDAO dao;
	
	@GetMapping("/getAll")
	public List<Doctor> getAllDoctors(){
		return dr.findAll();
	}
	//add doctor with hospital
	
	@PostMapping("/add/{hospital_id}")
	public void addDoc(@RequestBody Doctor d,@PathVariable int hospital_id)
	{
		Hospital h = hr.getById(hospital_id);
		d.setHospital(h);
		
		dr.save(d);	
		
	}
	
	@GetMapping("/getbyid/{id}")
	public Doctor getDoctorById(@PathVariable int id){
		return dr.getById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void removeDoctorById(@PathVariable int id){
		Doctor doc = dr.getById(id);
		if(doc != null)
		{
			 dr.deleteById(id);
		}		
	}
	
	@PostMapping("/login/{doctor_Username}/{doctor_Password}")
	public Doctor LoginValidation(@PathVariable("doctor_Username") String doctor_Username,@PathVariable("doctor_Password") String doctor_Password)
	{
		System.out.println(doctor_Username+" "+doctor_Password);
		
		return dao.LoginValidation(doctor_Username, doctor_Password);
	}
}
