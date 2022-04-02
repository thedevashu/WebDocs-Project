package com.java.webdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.webdocs.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	public List<Patient> findByUsername(String patient_Username);
}
