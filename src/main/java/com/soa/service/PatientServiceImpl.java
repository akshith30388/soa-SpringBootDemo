package com.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soa.entity.Patient;
import com.soa.repository.PatientRepo;
@Service
public class PatientServiceImpl implements PatientServicee{
	@Autowired
	private PatientRepo repo;
	@Override
	public Patient addPatient(Patient patient) {
		return repo.save(patient);
		//save method --->insertion and updation 
	}

	@Override
	public List<Patient> displayAllPatients() {
		return repo.findAll();
	}
	public List<Patient> displaypatientByGender(String gender){
		return repo.findByGender(gender);
	}
	public String deletePatientById(Long id) {
		if(repo.existsById(id)) {
		repo.deleteById(id);
		return "Deleted Successfully";
		}else {
			return "Not Found";
		}
	}
	public Patient displaybyId(Long id) {
		return repo.findById(id).orElse(null);
	}
	@Override
	public Patient updatePatient(Patient patient) {
		Optional<Patient> old=repo.findById(patient.getId());
		if(old.isPresent()) {
			Patient existingPatient =old.get();
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
		else {
			return null;
		}
	}

	

}
