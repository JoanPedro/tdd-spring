package com.tdd.spring.firstlook.domain.patient_pj;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Patient implements Serializable {
  private static final long serialVersionUID = 1L;

  // If this is Many to Many, need the table that joins the two side of relationship
  // CASCADE ALL operation to this relationship table
  // EAGER for returns immediately those patients on Patients calls
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
  @JoinTable(
      name = "patients_doctors",
      joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  )
  private final Set<Doctor> doctors = new HashSet<>();

  // Cascade All operation to this relationship table
  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
  private final List<Appointment> appointments = new ArrayList<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private String phone;

  @Embedded
  private Insurance insurance;

  public Patient() {
  }

  public Patient(Long id, String firstName, String lastName, String phone, Insurance insurance) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.insurance = insurance;
  }

  public Set<Doctor> getDoctors() {
    return doctors;
  }

  public List<Appointment> getAppointments() {
    return appointments;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  public void addDoctor(Iterable<Doctor> doctors) {
    doctors.forEach(doctor -> {
      getDoctors().add(doctor);
      doctor.getPatients().add(this);
    });
  }

  public void addAppointment(Iterable<Appointment> appointments) {
    appointments.forEach(appointment -> {
      appointment.setPatient(this);
      getAppointments().add(appointment);
    });
  }

  @Override
  public String toString() {
    return "Patient{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", phone='" + phone + '\'' +
        ", insurance=" + insurance +
        '}';
  }
}
