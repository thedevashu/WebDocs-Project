package com.java.webdocs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.webdocs.entity.Appointment;
import com.java.webdocs.entity.Doctor;
import com.java.webdocs.entity.Feedback;
import com.java.webdocs.entity.Patient;
import com.java.webdocs.entity.Slot;
import com.java.webdocs.repository.AppoinmentRepositry;
import com.java.webdocs.repository.DoctorRepository;
import com.java.webdocs.repository.FeedbackRepositry;
import com.java.webdocs.repository.PatientRepository;
import com.java.webdocs.repository.SlotRepository;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientRepository pr;
	
	@Autowired
	private DoctorRepository dr;
	@Autowired
	private SlotRepository sr;
	@Autowired
	private AppoinmentRepositry ar;
	
	@GetMapping("/getAll")
	public List<Patient> getAllPatient(){
		return pr.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public void deletePatient(@PathVariable int id) {
		 pr.deleteById(id);
	}
	
	@GetMapping("getById/{id}")
	public Patient getPatient(@PathVariable int id) {
		System.out.println("id======="+id+"--------------------------\n\n");
		Patient p = pr.getById(id);
		System.out.println(p);
		return p;
	}
	
	@PostMapping("/add")
	public boolean addPatient(@RequestBody Patient p) {
		boolean status = false;
		pr.save(p);
		status =true;
		return status;
	}
	//book appoinment
	@PostMapping("/bookSlot/{pid}/{did}")
	public void bookAppoinment(@PathVariable int pid,@PathVariable int did,@RequestBody Slot s) {
		Doctor d = dr.getById(did);
		Patient p = pr.getById(pid);
		Appointment a = new Appointment();
		a.setDoctor(d);
		a.setPatient(p);
		s.setHospital(d.getHospital() != null ? d.getHospital():null);
		s.addAppointment(a);
		s.setDoctor(d);
		
		sr.save(s);
		
		
	}
	@GetMapping("/getAppointment/{pid}")
	public List<Appointment> getPatientAppointment(@PathVariable int pid) {
		Patient p = pr.getById(pid);
		return p.getAppointments();
	}
	
	@PostMapping("/addFeedback/{pid}/{did}")
	public boolean AddFeedback(@PathVariable int pid,@PathVariable int did,@RequestBody Feedback fb) {
		System.out.println("pid="+pid +" did="+did);
		boolean status = false;
		Patient p= pr.getById(pid);
		fb.setPatient(p);
		Doctor d= dr.getById(did);
		fb.setDoctor(d);
		d.addFeedback(fb);
		dr.save(d);
		status = true;
		return status;
	}

}
