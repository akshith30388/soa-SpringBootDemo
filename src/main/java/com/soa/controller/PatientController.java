package com.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soa.entity.Patient;
import com.soa.service.PatientServiceImpl;

@RestController
public class PatientController {
	@Autowired
private PatientServiceImpl service;

	@GetMapping("/")
	public String test() {
	return "SOA";
	}
	//200 for 
	@GetMapping("/displayall")
	public ResponseEntity<List<Patient>> displayallpatients() {
		List<Patient> patients=service.displayAllPatients();
		return ResponseEntity.status(200).body(patients);
	}
	//201 created 
	@PostMapping("/add")
	//client ---> server (json payload)
	public ResponseEntity<Patient> add(@RequestBody Patient patient) {
		Patient p=service.addPatient(patient);
		return ResponseEntity.status(201).body(p);
	}
	
	
}
