package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.patient_pj.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
