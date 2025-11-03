package com.renu.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	private String name;
	private String email;
	private String address;
	public Patient() {
		
	}
	public Patient(long patientId, String name, String email, String address) {
		
		this.patientId = patientId;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
