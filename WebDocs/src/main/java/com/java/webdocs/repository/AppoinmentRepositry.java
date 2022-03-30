package com.java.webdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.webdocs.entity.Appointment;

public interface AppoinmentRepositry  extends JpaRepository<Appointment	, Integer>{

}
