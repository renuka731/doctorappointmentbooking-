package com.renu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renu.model.Patient;
import com.renu.repo.PatientRepo;

@Service
public class PatientService {
@Autowired
private PatientRepo patientrepo;

public Patient register(Patient p) {
	return patientrepo.save(p);
}

}
