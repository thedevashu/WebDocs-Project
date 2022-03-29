package com.java.webdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.webdocs.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
