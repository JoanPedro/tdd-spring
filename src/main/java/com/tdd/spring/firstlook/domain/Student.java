package com.tdd.spring.firstlook.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Student implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fname")
  private String firstName;

  @Column(name = "lname")
  private String lastName;

  private Integer score;

  public Student() {
  }

  public Student(Long id, String firstName, String lastName, Integer score) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
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

  public void setFirstName(String fistName) {
    this.firstName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }
}
