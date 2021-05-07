package com.tdd.spring.firstlook.domain.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Define witch data will be used to persist
@DiscriminatorValue("CC")
public class CreditCard extends Payment {
  private String creditCard;

  public CreditCard() {

  }

  public CreditCard(String creditCard) {
    this.creditCard = creditCard;
  }

  public String getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(String creditCard) {
    this.creditCard = creditCard;
  }
}
