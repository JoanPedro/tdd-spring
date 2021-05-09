package com.tdd.spring.firstlook.domain.patient_pj;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Appointment implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Timestamp appointmentTime;
  private Boolean started;
  private Boolean ended;
  private String reason;

  // Inverse-Side: Needs Join Column to identify Doctor to this Appointment
  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  // Inverse-Side: Needs Join Column to identify Patient to this Appointment
  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  public Appointment() {
  }

  public Appointment(Long id, Timestamp appointmentTime, Boolean started, Boolean ended, String reason) {
    this.id = id;
    this.appointmentTime = appointmentTime;
    this.started = started;
    this.ended = ended;
    this.reason = reason;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Timestamp getAppointmentTime() {
    return appointmentTime;
  }

  public void setAppointmentTime(Timestamp appointmentTime) {
    this.appointmentTime = appointmentTime;
  }

  public Boolean getStarted() {
    return started;
  }

  public void setStarted(Boolean started) {
    this.started = started;
  }

  public Boolean getEnded() {
    return ended;
  }

  public void setEnded(Boolean ended) {
    this.ended = ended;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public String toString() {
    return "Appointment{" +
        "id=" + id +
        ", appointmentTime=" + appointmentTime +
        ", started=" + started +
        ", ended=" + ended +
        ", reason='" + reason + '\'' +
        '}';
  }
}
