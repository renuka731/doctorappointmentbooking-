package com.renu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renu.model.Doctor;
import com.renu.service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
	@Autowired
	private DoctorService ds;
	
@PostMapping("/adddoctordetails")
public Doctor addDoctorDetails(@RequestBody Doctor d) {
    
    
    return ds.saveDoctorDetails(d);
}

}
