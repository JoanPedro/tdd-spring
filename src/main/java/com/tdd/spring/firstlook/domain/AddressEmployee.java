package com.tdd.spring.firstlook.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class AddressEmployee implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Embedded
  private Address address;

  public AddressEmployee() {
  }

  public AddressEmployee(Long id, String name, Address address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
