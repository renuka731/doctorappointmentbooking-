package com.renu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renu.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

}
