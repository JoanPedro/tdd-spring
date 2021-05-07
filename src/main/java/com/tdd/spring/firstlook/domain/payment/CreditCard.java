package com.tdd.spring.firstlook.domain.payment;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id")
@JsonTypeName("CC")
public class CreditCard extends Payment {

  @Column
  private String cardNumber;

  public CreditCard(Long id, Double amount, String cardNumber) {
    super(id, amount);
    this.cardNumber = cardNumber;
  }

  public CreditCard() {

  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
}
