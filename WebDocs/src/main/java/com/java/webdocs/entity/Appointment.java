package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "appointment_id")
	private int appointment_id;

	private byte appointment_Status;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="Appointment_Doctor_id")
	private Doctor doctor;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="Appointment_Patient_id")
	private Patient patient;

	//bi-directional many-to-one association to Slot
	@ManyToOne
	@JoinColumn(name="Appointment_slot_id")
	private Slot slot;

	public Appointment() {
	}

	public Appointment(int appointment_id, byte appointment_Status, Doctor doctor, Patient patient, Slot slot) {
		super();
		this.appointment_id = appointment_id;
		this.appointment_Status = appointment_Status;
		this.doctor = doctor;
		this.patient = patient;
		this.slot = slot;
	}

	public int getAppointment_id() {
		return this.appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public byte getAppointment_Status() {
		return this.appointment_Status;
	}

	public void setAppointment_Status(byte appointment_Status) {
		this.appointment_Status = appointment_Status;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Slot getSlot() {
		return this.slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", appointment_Status=" + appointment_Status
				+ "]";
	}

}