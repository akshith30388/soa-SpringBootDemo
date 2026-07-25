package com.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soa.entity.Patient;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{
	//custom methods 
	//select * from Patient where gender="male";
	List<Patient> findByGender(String gender);
	
}
