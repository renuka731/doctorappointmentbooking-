package com.renu.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renu.model.Appointment;
import com.renu.model.Doctor;
import com.renu.model.Patient;
import com.renu.repo.AppointmentRepo;
import com.renu.repo.DoctorRepo;
import com.renu.repo.PatientRepo;

@Service
public class AppointmentService {
	@Autowired
private AppointmentRepo apprepo;
@Autowired
private DoctorRepo drepo;
@Autowired
private PatientRepo prepo;

	
	public Appointment bookAppointment(long patientId,long doctorId,Appointment app) {
		Doctor d =drepo.findById(doctorId)
				.orElseThrow(() -> new RuntimeException("Patient not found"));
		Patient p =prepo.findById(patientId).orElseThrow((()-> new RuntimeException("patient not found")));
		Appointment appointment =new Appointment();
		appointment.setPatient(p);
		appointment.setDoctor(d);
		appointment.setAppointmentdate(app.getAppointmentdate());
		appointment.setStatus(app.getStatus());
        return apprepo.save(appointment);
	}
public List<Appointment> getAllAppointments(){
	return apprepo.findAll();
}
public List<Appointment> getAppointmentsByDoctornameAndDate(String doctorname){
	return apprepo.findByDoctorNameAndDate(doctorname);
}
}
