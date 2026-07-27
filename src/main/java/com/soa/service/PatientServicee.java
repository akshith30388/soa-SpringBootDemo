package com.soa.service;

import java.util.List;

import com.soa.entity.Patient;

public interface PatientServicee {
	Patient addPatient(Patient patient);
	List<Patient> displayAllPatients();
	Patient updatePatient(Patient patient);
	Patient displaybyId(Long id);
	List<Patient> displaypatientByGender(String gender);
	String deletePatientById(Long id);
	int displayPatientCount();
}
