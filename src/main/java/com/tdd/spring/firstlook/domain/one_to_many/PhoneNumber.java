package com.tdd.spring.firstlook.domain.one_to_many;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PhoneNumber implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String number;

  private String type;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public PhoneNumber(Long id, String number, String type) {
    this.id = id;
    this.number = number;
    this.type = type;
  }

  public PhoneNumber() {
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
