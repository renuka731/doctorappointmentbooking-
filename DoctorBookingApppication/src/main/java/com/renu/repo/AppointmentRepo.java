package com.renu.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>{
@Query("SELECT a FROM Appointment a WHERE a.doctor.name = :doctorName ")
List<Appointment> findByDoctorNameAndDate(@Param("doctorName") String doctorName);
        
}
