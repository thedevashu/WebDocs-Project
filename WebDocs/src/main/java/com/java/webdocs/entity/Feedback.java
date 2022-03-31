package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
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
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "feedback_Id")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedback_Id;

	private int feedback_Rating;

	private String feedback_Text;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="Feedback_Doctor_Id")
	private Doctor doctor;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="Feedback_Patient_Id")
	private Patient patient;

	public Feedback() {
	}

	public Feedback(int feedback_Id, int feedback_Rating, String feedback_Text, Doctor doctor, Patient patient) {
		super();
		this.feedback_Id = feedback_Id;
		this.feedback_Rating = feedback_Rating;
		this.feedback_Text = feedback_Text;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getFeedback_Id() {
		return this.feedback_Id;
	}

	public void setFeedback_Id(int feedback_Id) {
		this.feedback_Id = feedback_Id;
	}

	public int getFeedback_Rating() {
		return this.feedback_Rating;
	}

	public void setFeedback_Rating(int feedback_Rating) {
		this.feedback_Rating = feedback_Rating;
	}

	public String getFeedback_Text() {
		return this.feedback_Text;
	}

	public void setFeedback_Text(String feedback_Text) {
		this.feedback_Text = feedback_Text;
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

	@Override
	public String toString() {
		return "Feedback [feedback_Id=" + feedback_Id + ", feedback_Rating=" + feedback_Rating + ", feedback_Text="
				+ feedback_Text + "]";
	}

}