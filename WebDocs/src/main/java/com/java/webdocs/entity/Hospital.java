package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
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

@Entity
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospital_id;

	private String hospital_Address;

//	@Lob
//	private byte[] hospital_Image;

	private String hospital_Name;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="hospital",cascade = CascadeType.ALL)
	private List<Doctor> doctors;

	//bi-directional many-to-one association to Slot
	@OneToMany(mappedBy="hospital",cascade = CascadeType.ALL)
	private List<Slot> slots;

	public Hospital() {
	}

	public Hospital(int hospital_id, String hospital_Address, byte[] hospital_Image, String hospital_Name,
			List<Doctor> doctors, List<Slot> slots) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_Address = hospital_Address;
//		this.hospital_Image = hospital_Image;
		this.hospital_Name = hospital_Name;
		this.doctors = doctors;
		this.slots = slots;
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

//	public byte[] getHospital_Image() {
//		return this.hospital_Image;
//	}
//
//	public void setHospital_Image(byte[] hospital_Image) {
//		this.hospital_Image = hospital_Image;
//	}

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
		return "Hospital [hospital_id=" + hospital_id + ", hospital_Address=" + hospital_Address + ", hospital_Image="
				+ ", hospital_Name=" + hospital_Name + ", doctors=" + doctors
				+ ", slots=" + slots + "]";
	}

}