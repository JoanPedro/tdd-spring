package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.patient_pj.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
