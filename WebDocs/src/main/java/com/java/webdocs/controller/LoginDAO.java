package com.java.webdocs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webdocs.entity.Doctor;
import com.java.webdocs.entity.Patient;
import com.java.webdocs.repository.DoctorRepository;
import com.java.webdocs.repository.PatientRepository;

@Service
public class LoginDAO {


	@Autowired
	private DoctorRepository repository;

	public Doctor LoginValidation(String doctor_Username, String doctor_Password) {
		List<Doctor> org =  repository.findByUsername(doctor_Username);
		if(org!=null) 
		{
			for(Doctor pt : org) {
		if(pt.getDoctor_Username().equals(doctor_Username) && pt.getDoctor_Password().equals(doctor_Password))
		return pt;
		else
			return null;
		}
		}
		
		return null;
	}
	
	@Autowired
	private PatientRepository repository1;
	
	public Patient LoginValide(String patient_Username, String patient_Password) {
		List<Patient> org =  repository1.findByUsername(patient_Username);
		if(org!=null) 
		{
			for(Patient pt : org) {
		if(pt.getPatient_Username().equals(patient_Username) && pt.getPatient_Password().equals(patient_Password))
		return pt;
		else
			return null;
		}
		}
		
		return null;
	}
	
}
