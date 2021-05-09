package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.patient_pj.Appointment;
import com.tdd.spring.firstlook.domain.patient_pj.Doctor;
import com.tdd.spring.firstlook.domain.patient_pj.Insurance;
import com.tdd.spring.firstlook.domain.patient_pj.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PatientPjTest {

  @Autowired
  DoctorRepository doctorRepository;

  @Autowired
  PatientRepository patientRepository;

  @Autowired
  AppointmentRepository appointmentRepository;

  @Test
  void IntegrationTest() {
    Doctor d1 = new Doctor(null, "Bharath", "Vanir", "Cardiologist");
    Doctor d2 = new Doctor(null, "Khatywl", "Mohantm", "Podiatrist");
    Doctor d3 = new Doctor(null, "Mhakaty", "Polythean", "Generalist");
    Doctor d4 = new Doctor(null, "Amdn", "Psameth", "Others");

    Insurance i1 = new Insurance("Sulamerica", 399.99);
    Insurance i2 = new Insurance("Bradesco", 399.99);

    Patient p1 = new Patient(null, "Joan Pedro", "Oliveira de Souza", "719999999", i1);
    Patient p2 = new Patient(null, "Tales", "de Souza", "719999999", i2);
    Patient p3 = new Patient(null, "Pedro", "Oliveira", "719999999", i2);
    Patient p4 = new Patient(null, "Karth", "Mekhihitan", "719999999", i1);

    Appointment ap1 = new Appointment();
    Appointment ap2 = new Appointment();
    Appointment ap3 = new Appointment();
    Appointment ap4 = new Appointment();

    p1.addDoctor(Arrays.asList(d1, d2));
    p2.addDoctor(Arrays.asList(d2, d3));
    p3.addDoctor(Arrays.asList(d3, d1));
    p4.addDoctor(Collections.singletonList(d4));

    p1.addAppointment(Arrays.asList(ap1, ap2));
    d1.addAppointment(Arrays.asList(ap1, ap2));
    p2.addAppointment(Arrays.asList(ap2, ap3));
    d2.addAppointment(Arrays.asList(ap2, ap3));
    p3.addAppointment(Arrays.asList(ap3, ap1));
    d3.addAppointment(Arrays.asList(ap3, ap1));
    p4.addAppointment(Collections.singletonList(ap4));
    d4.addAppointment(Collections.singletonList(ap4));

    patientRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
  }
}
