package com.tdd.spring.firstlook.domain.patient_pj;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Doctor implements Serializable {
  private static final long serialVersionUID = 1L;

  // Inverse-Side to identify what field was relationship with those patients
  @ManyToMany(mappedBy = "doctors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private final Set<Patient> patients = new HashSet<>();

  // Cascade All operation to this relationship table
  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
  private final List<Appointment> appointments = new ArrayList<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private String speciality;

  public Doctor() {
  }

  public Doctor(Long id, String firstName, String lastName, String speciality) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.speciality = speciality;
  }

  public Set<Patient> getPatients() {
    return patients;
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

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public void addAppointment(Iterable<Appointment> appointments) {
    appointments.forEach(appointment -> {
      appointment.setDoctor(this);
      getAppointments().add(appointment);
    });
  }

  @Override
  public String toString() {
    return "Doctor{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", speciality='" + speciality + '\'' +
        '}';
  }
}
