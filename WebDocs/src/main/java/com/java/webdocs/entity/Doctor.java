package com.java.webdocs.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "doctor_Id")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctor_Id;

	@Temporal(TemporalType.DATE)
	private Date doctor_DOB;

	private String doctor_Email;

	private int doctor_Experience;

	private int doctor_Fees;

	private String doctor_Gender;

	private String doctor_License_Number;

	private String doctor_Mobile_number;

	private String doctor_Name;

	private String doctor_Password;

	@Lob
	private byte[] doctor_Photo;

	@Column(name="doctor_Username")
	private String username;
	//private String doctor_Username;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="doctor",cascade= CascadeType.ALL)
	private List<Appointment> appointments;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="Doctor_Category_Id")
	private Category category;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="Doctor_Hospital_Id")
	private Hospital hospital;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="doctor",cascade= CascadeType.ALL)
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Slot
	@OneToMany(mappedBy="doctor",cascade= CascadeType.ALL)
	private List<Slot> slots;

	public Doctor() {
		slots = new ArrayList<Slot>();
		feedbacks = new ArrayList<>();
		appointments = new ArrayList<>();
		
	}

	public Doctor(int doctor_Id, Date doctor_DOB, String doctor_Email, int doctor_Experience, int doctor_Fees,
			String doctor_Gender, String doctor_License_Number, String doctor_Mobile_number, String doctor_Name,
			String doctor_Password, byte[] doctor_Photo, String doctor_Username, List<Appointment> appointments,
			Category category, Hospital hospital, List<Feedback> feedbacks, List<Slot> slots) {
		super();
		this.doctor_Id = doctor_Id;
		this.doctor_DOB = doctor_DOB;
		this.doctor_Email = doctor_Email;
		this.doctor_Experience = doctor_Experience;
		this.doctor_Fees = doctor_Fees;
		this.doctor_Gender = doctor_Gender;
		this.doctor_License_Number = doctor_License_Number;
		this.doctor_Mobile_number = doctor_Mobile_number;
		this.doctor_Name = doctor_Name;
		this.doctor_Password = doctor_Password;
		this.doctor_Photo = doctor_Photo;
		this.username = doctor_Username;
		this.appointments = appointments;
		this.category = category;
		this.hospital = hospital;
		this.feedbacks = feedbacks;
		this.slots = slots;
	}

	public int getDoctor_Id() {
		return this.doctor_Id;
	}

	public void setDoctor_Id(int doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public Date getDoctor_DOB() {
		return this.doctor_DOB;
	}

	public void setDoctor_DOB(Date doctor_DOB) {
		this.doctor_DOB = doctor_DOB;
	}

	public String getDoctor_Email() {
		return this.doctor_Email;
	}

	public void setDoctor_Email(String doctor_Email) {
		this.doctor_Email = doctor_Email;
	}

	public int getDoctor_Experience() {
		return this.doctor_Experience;
	}

	public void setDoctor_Experience(int doctor_Experience) {
		this.doctor_Experience = doctor_Experience;
	}

	public int getDoctor_Fees() {
		return this.doctor_Fees;
	}

	public void setDoctor_Fees(int doctor_Fees) {
		this.doctor_Fees = doctor_Fees;
	}

	public String getDoctor_Gender() {
		return this.doctor_Gender;
	}

	public void setDoctor_Gender(String doctor_Gender) {
		this.doctor_Gender = doctor_Gender;
	}

	public String getDoctor_License_Number() {
		return this.doctor_License_Number;
	}

	public void setDoctor_License_Number(String doctor_License_Number) {
		this.doctor_License_Number = doctor_License_Number;
	}

	public String getDoctor_Mobile_number() {
		return this.doctor_Mobile_number;
	}

	public void setDoctor_Mobile_number(String doctor_Mobile_number) {
		this.doctor_Mobile_number = doctor_Mobile_number;
	}

	public String getDoctor_Name() {
		return this.doctor_Name;
	}

	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}

	public String getDoctor_Password() {
		return this.doctor_Password;
	}

	public void setDoctor_Password(String doctor_Password) {
		this.doctor_Password = doctor_Password;
	}

	public byte[] getDoctor_Photo() {
		return this.doctor_Photo;
	}

	public void setDoctor_Photo(byte[] doctor_Photo) {
		this.doctor_Photo = doctor_Photo;
	}

	public String getDoctor_Username() {
		return this.username;
	}

	public void setDoctor_Username(String doctor_Username) {
		this.username = doctor_Username;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setDoctor(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setDoctor(null);

		return appointment;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setDoctor(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setDoctor(null);

		return feedback;
	}

	public List<Slot> getSlots() {
		return this.slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Slot addSlot(Slot slot) {
		getSlots().add(slot);
		slot.setDoctor(this);

		return slot;
	}

	public Slot removeSlot(Slot slot) {
		getSlots().remove(slot);
		slot.setDoctor(null);

		return slot;
	}

	@Override
	public String toString() {
		return "Doctor [doctor_Id=" + doctor_Id + ", doctor_DOB=" + doctor_DOB + ", doctor_Email=" + doctor_Email
				+ ", doctor_Experience=" + doctor_Experience + ", doctor_Fees=" + doctor_Fees + ", doctor_Gender="
				+ doctor_Gender + ", doctor_License_Number=" + doctor_License_Number + ", doctor_Mobile_number="
				+ doctor_Mobile_number + ", doctor_Name=" + doctor_Name + ", doctor_Password=" + doctor_Password
				+ ", doctor_Photo=" + Arrays.toString(doctor_Photo) + ", doctor_Username=" + username
				+ "]";
	}

}