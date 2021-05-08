package com.tdd.spring.firstlook.domain.one_to_one;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class License implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;

  @Temporal(TemporalType.DATE)
  private Date validFrom;

  @Temporal(TemporalType.DATE)
  private Date validTo;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "person_id")
  private Person person;

  public License() {
  }

  public License(Long id, String type, Date validFrom, Date validTo) {
    this.id = id;
    this.type = type;
    this.validFrom = validFrom;
    this.validTo = validTo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void addPerson(Person person) {
    person.setLicense(this);
    setPerson(person);
  }
}
