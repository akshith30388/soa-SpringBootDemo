package com.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soa.entity.Patient;
@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{

}
