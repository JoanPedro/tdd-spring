package com.tdd.spring.firstlook.domain.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Define witch data will be used to persist
@DiscriminatorValue("CH")
public class Check extends Payment{

  private String checkNumber;

  public Check() {

  }

  public Check(String checkNumber) {
    this.checkNumber = checkNumber;
  }

  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }
}
