package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "category_id")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;

	private String description;

	private String specialization;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="category",cascade= CascadeType.ALL)
	private List<Doctor> doctors;

	public Category() {
		doctors = new ArrayList<>();
		
	}

	public Category(int category_id, String description, String specialization, List<Doctor> doctors) {
		super();
		this.category_id = category_id;
		this.description = description;
		this.specialization = specialization;
		this.doctors = doctors;
	}

	public int getCategory_id() {
		return this.category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setCategory(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setCategory(null);

		return doctor;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", description=" + description +  "]";
	}

}