package com.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soa.entity.Patient;

import com.soa.service.PatientService;

@RestController
public class Controller {
	
	@Autowired
	private PatientService  service;
	//CRUD 
	//read
	@GetMapping("/get")
	public List<Patient> getall(){
		return service.getall();
	}
	//create
	@PostMapping("/post")
	public String update(@RequestBody Patient patient) {
		return service.update(patient);
	}
	//delete
	@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable Long id) {
			return service.delete(id);
		}
	//update
	@PutMapping("/modify/{id}")
	public Patient modify(@PathVariable Long id ,@RequestBody Patient patient) {
		return service.modify(id,patient);
	}
}

