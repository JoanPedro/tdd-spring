package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.patient_pj.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
