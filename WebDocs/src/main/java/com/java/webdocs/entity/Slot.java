package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@NamedQuery(name="Slot.findAll", query="SELECT s FROM Slot s")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "slot_id")
public class Slot implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int slot_id;

	@Temporal(TemporalType.DATE)
	private Date slot_Date;

	private Time slot_End_Time;

	private Time slot_Start_Time;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="slot",cascade= CascadeType.ALL)
	private List<Appointment> appointments;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="Slot_Doctor_id")
	private Doctor doctor;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="Hospital_id")
	private Hospital hospital;

	public Slot() {
		appointments = new ArrayList<Appointment>();
	}

	public Slot(int slotId, Date slot_Date, Time slot_End_Time, Time slot_Start_Time, List<Appointment> appointments,
			Doctor doctor, Hospital hospital) {
		super();
		
		this.slot_Date = slot_Date;
		this.slot_End_Time = slot_End_Time;
		this.slot_Start_Time = slot_Start_Time;
		this.appointments = appointments;
		this.doctor = doctor;
		this.hospital = hospital;
	}

	
	public Date getSlot_Date() {
		return this.slot_Date;
	}

	public void setSlot_Date(Date slot_Date) {
		this.slot_Date = slot_Date;
	}

	public Time getSlot_End_Time() {
		return this.slot_End_Time;
	}

	public void setSlot_End_Time(Time slot_End_Time) {
		this.slot_End_Time = slot_End_Time;
	}

	public Time getSlot_Start_Time() {
		return this.slot_Start_Time;
	}

	public void setSlot_Start_Time(Time slot_Start_Time) {
		this.slot_Start_Time = slot_Start_Time;
	}
	public int getSlot_id() {
		return slot_id;
	}

	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setSlot(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setSlot(null);

		return appointment;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Slot [slotId=" + slot_id + ", slot_Date=" + slot_Date + ", slot_End_Time=" + slot_End_Time
				+ ", slot_Start_Time=" + slot_Start_Time +  "]";
	}

}