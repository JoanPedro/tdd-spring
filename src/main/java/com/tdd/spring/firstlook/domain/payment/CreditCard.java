package com.tdd.spring.firstlook.domain.payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Define witch data will be used to persist
@DiscriminatorValue("CC")
public class CreditCard extends Payment {
  private String cardNumber;

  public CreditCard() {

  }

  public CreditCard(String creditCard) {
    this.cardNumber = creditCard;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
}
