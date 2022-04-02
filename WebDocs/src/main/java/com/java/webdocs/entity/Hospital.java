package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "hospital_id")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospital_id;

	private String hospital_Address;

	private String hospital_Name;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="hospital",cascade= CascadeType.ALL)
	private List<Doctor> doctors;

	//bi-directional many-to-one association to Slot
	@OneToMany(mappedBy="hospital",cascade= CascadeType.ALL)
	private List<Slot> slots;

	public Hospital() {
		slots = new ArrayList<Slot>();
		doctors = new ArrayList<>();
	}

	

	public int getHospital_id() {
		return this.hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_Address() {
		return this.hospital_Address;
	}

	public void setHospital_Address(String hospital_Address) {
		this.hospital_Address = hospital_Address;
	}

	

	public String getHospital_Name() {
		return this.hospital_Name;
	}

	public void setHospital_Name(String hospital_Name) {
		this.hospital_Name = hospital_Name;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setHospital(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setHospital(null);

		return doctor;
	}

	public List<Slot> getSlots() {
		return this.slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Slot addSlot(Slot slot) {
		getSlots().add(slot);
		slot.setHospital(this);

		return slot;
	}

	public Slot removeSlot(Slot slot) {
		getSlots().remove(slot);
		slot.setHospital(null);

		return slot;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hospital_Address=" + hospital_Address 
				 + "]";
	}

}