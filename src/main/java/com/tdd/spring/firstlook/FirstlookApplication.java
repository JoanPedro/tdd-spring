package com.tdd.spring.firstlook;

import com.tdd.spring.firstlook.domain.patient_pj.Appointment;
import com.tdd.spring.firstlook.domain.patient_pj.Doctor;
import com.tdd.spring.firstlook.domain.patient_pj.Insurance;
import com.tdd.spring.firstlook.domain.patient_pj.Patient;
import com.tdd.spring.firstlook.domain.steps.*;
import com.tdd.spring.firstlook.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class FirstlookApplication implements CommandLineRunner {

  @Autowired
  DoctorRepository doctorRepository;

  @Autowired
  PatientRepository patientRepository;

  @Autowired
  Client2Repository client2Repository;

  @Autowired
  Product2Repository product2Repository;

  @Autowired
  Order2Repository order2Repository;

  @Autowired
  Order2ItemRepository order2ItemRepository;

  public static void main(String[] args) {
    SpringApplication.run(FirstlookApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
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

    Client2 c1 = new Client2(null, "Alex Green", "alex@gmail.com");

    client2Repository.save(c1);

    Product2 pp1 = new Product2(null, "TV", 1000.00);
    Product2 pp2 = new Product2(null, "Mouse", 40.00);
    Product2 pp3 = new Product2(null, "PC", 1200.00);

    product2Repository.saveAll(Arrays.asList(pp1, pp2, pp3));

    Order2 o1 = new Order2(null, Instant.parse("2021-04-18T11:25:09Z"), Order2Status.PAID, c1);
    Order2 o2 = new Order2(null, Instant.parse("2021-04-20T11:25:09Z"), Order2Status.WAITING, c1);

    Order2Item iz1 = new Order2Item(null, 1, 1000.0, pp1, o1);
    Order2Item iz2 = new Order2Item(null, 2, 40.0, pp2, o1);
    Order2Item iz3 = new Order2Item(null, 1, 40.0, pp2, o2);
    Order2Item iz4 = new Order2Item(null, 1, 1200.0, pp3, o2);

    o1.addOrders(Arrays.asList(iz1, iz2));
    o2.addOrders(Arrays.asList(iz3, iz4));

    order2Repository.saveAll(Arrays.asList(o1, o2));
  }
}
