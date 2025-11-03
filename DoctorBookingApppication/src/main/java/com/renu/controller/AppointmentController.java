package com.renu.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.model.Appointment;
import com.renu.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book/{doctorId}/{patientId}")
    public Appointment book(@PathVariable Long patientId, @PathVariable Long doctorId,
                                            @RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(patientId, doctorId, appointment);
    }
    @GetMapping("/appointmentlist")
    public List<Appointment> getAppointmentList(){
    	return appointmentService.getAllAppointments();
    }
    @GetMapping("/{doctorName}")
    public List<Appointment> getAppointmentsByDoctorname(@PathVariable String doctorName){
    	
    	return appointmentService.getAppointmentsByDoctornameAndDate(doctorName);
    }
}
