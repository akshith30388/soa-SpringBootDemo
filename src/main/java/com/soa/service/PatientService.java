package com.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soa.entity.Patient;
import com.soa.repository.PatientRepo;
@Service
public class PatientService {
	@Autowired
private PatientRepo repo;
	
	public List<Patient> getall(){
		return repo.findAll();
	}

	public String update(Patient patient) {
		if(repo.existsById(patient.getId())) {
			return "All Ready Exist In Database With Id "+ patient.getId() +" ";
		}else {
		repo.save(patient);
		return "Updated Database";
		}
	}

	public String delete(Long id) {
		Optional<Patient> p=repo.findById(id);
		if(p!=null) {
			repo.deleteById(id);
			return "Deleted From DataBase";
		}else {
		return "Cannot Find Id";
		}
	}

	public Patient modify(Long id, Patient patient) {
		Optional<Patient> oldDetailes=repo.findById(id);
		Patient existingPatient=oldDetailes.get();
		if(existingPatient==null) return null;
		else {
			
			existingPatient.setAge(patient.getAge());
			existingPatient.setContact(patient.getContact());
			existingPatient.setLocation(patient.getLocation());
			existingPatient.setGender(patient.getGender());
			existingPatient.setName(patient.getName());
			existingPatient.setRemarks(patient.getRemarks());
			existingPatient.setEmail(patient.getEmail());
			existingPatient.setCreatedAt(patient.getCreatedAt());
			existingPatient.setStatus(patient.isStatus());
			repo.save(existingPatient);
			return existingPatient;
		}
	}
}
