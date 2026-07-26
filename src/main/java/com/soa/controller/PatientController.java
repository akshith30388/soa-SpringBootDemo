package com.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	// Display Patient By ID
	//404 is for not found
	@GetMapping("/display")
	public ResponseEntity<?> displayPatientById(@RequestBody Long id){
		Patient p=service.displaybyId(id);
		if(p==null) {
			return ResponseEntity.status(404).body("Patient ID Not Found");
		}else {
			return ResponseEntity.status(200).body(p);
		}
	}
	// Update Patient
	@PutMapping("/update")
	public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
		Patient p=service.updatePatient(patient);
		if(p==null) {
			return ResponseEntity.status(404).body("Patient ID Not Found");
		}else {
			return ResponseEntity.status(200).body(p);
		}
	}
	// Delete Patient By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id){
		String ans=service.deletePatientById(id);
		if(ans.equals("Deleted Successfully")) {
			return ResponseEntity.ok("Deleted Successfully");
		}else {
			return ResponseEntity.status(404).body("Patient ID Not Found");
		}
	}
	// Display Patients By Gender
		@GetMapping("/displaybygender/{gender}")
		public ResponseEntity<?> displayPatientsByGender(@PathVariable String gender)
		{
			List<Patient> bygender=service.displaypatientByGender(gender);
			if(bygender.isEmpty()) {
				return ResponseEntity.status(404).body("Patient ID Not Found");
			}else {
				return ResponseEntity.ok(bygender);
			}
		}
	
	
}
