package com.renu.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	 @JoinColumn(name = "doctorId")
	private Doctor doctor;
	@ManyToOne
	 @JoinColumn(name="patientId")
	private Patient patient;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentdate;
	private String status;
	public Appointment() {
		
	}
	public Appointment(Long id, Doctor doc, Patient p, LocalDate appointmentdate, String status) {
		super();
		this.id = id;
		this.doctor = doc;
		this.patient = p;
		this.appointmentdate = appointmentdate;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doc) {
		this.doctor = doc;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient p) {
		this.patient = p;
	}
	public LocalDate getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(LocalDate appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
