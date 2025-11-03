package com.renu.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.renu.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
