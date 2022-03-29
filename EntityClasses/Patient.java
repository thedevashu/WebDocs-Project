package com.java.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patient_Id;

	@Temporal(TemporalType.DATE)
	private Date patient_DOB;

	private String patient_Email;

	private String patient_Gender;

	private String patient_Mobile_number;

	private String patient_Name;

	private String patient_Password;

	@Lob
	private byte[] patient_Photo;

	private String patient_Username;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="patient")
	private List<Appointment> appointments;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="patient")
	private List<Feedback> feedbacks;

	public Patient() {
	}
	
	public Patient(int patient_Id, Date patient_DOB, String patient_Email, String patient_Gender,
			String patient_Mobile_number, String patient_Name, String patient_Password, byte[] patient_Photo,
			String patient_Username, List<Appointment> appointments, List<Feedback> feedbacks) {
		super();
		this.patient_Id = patient_Id;
		this.patient_DOB = patient_DOB;
		this.patient_Email = patient_Email;
		this.patient_Gender = patient_Gender;
		this.patient_Mobile_number = patient_Mobile_number;
		this.patient_Name = patient_Name;
		this.patient_Password = patient_Password;
		this.patient_Photo = patient_Photo;
		this.patient_Username = patient_Username;
		this.appointments = appointments;
		this.feedbacks = feedbacks;
	}

	public int getPatient_Id() {
		return this.patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}

	public Date getPatient_DOB() {
		return this.patient_DOB;
	}

	public void setPatient_DOB(Date patient_DOB) {
		this.patient_DOB = patient_DOB;
	}

	public String getPatient_Email() {
		return this.patient_Email;
	}

	public void setPatient_Email(String patient_Email) {
		this.patient_Email = patient_Email;
	}

	public String getPatient_Gender() {
		return this.patient_Gender;
	}

	public void setPatient_Gender(String patient_Gender) {
		this.patient_Gender = patient_Gender;
	}

	public String getPatient_Mobile_number() {
		return this.patient_Mobile_number;
	}

	public void setPatient_Mobile_number(String patient_Mobile_number) {
		this.patient_Mobile_number = patient_Mobile_number;
	}

	public String getPatient_Name() {
		return this.patient_Name;
	}

	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}

	public String getPatient_Password() {
		return this.patient_Password;
	}

	public void setPatient_Password(String patient_Password) {
		this.patient_Password = patient_Password;
	}

	public byte[] getPatient_Photo() {
		return this.patient_Photo;
	}

	public void setPatient_Photo(byte[] patient_Photo) {
		this.patient_Photo = patient_Photo;
	}

	public String getPatient_Username() {
		return this.patient_Username;
	}

	public void setPatient_Username(String patient_Username) {
		this.patient_Username = patient_Username;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setPatient(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setPatient(null);

		return appointment;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setPatient(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setPatient(null);

		return feedback;
	}

	@Override
	public String toString() {
		return "Patient [patient_Id=" + patient_Id + ", patient_DOB=" + patient_DOB + ", patient_Email=" + patient_Email
				+ ", patient_Gender=" + patient_Gender + ", patient_Mobile_number=" + patient_Mobile_number
				+ ", patient_Name=" + patient_Name + ", patient_Password=" + patient_Password + ", patient_Photo="
				+ Arrays.toString(patient_Photo) + ", patient_Username=" + patient_Username + ", appointments="
				+ appointments + ", feedbacks=" + feedbacks + "]";
	}

}