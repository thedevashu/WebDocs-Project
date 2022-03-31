package com.java.webdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.webdocs.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
