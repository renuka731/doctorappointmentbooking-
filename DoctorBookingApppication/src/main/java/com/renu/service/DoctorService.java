package com.renu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renu.model.Doctor;
import com.renu.repo.DoctorRepo;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo dr;
	 public Doctor saveDoctorDetails(Doctor d) {
		 return dr.save(d);
	 }
	 public List<Doctor> getAllDoctors(){
		 return dr.findAll();
		 
	 }
}
