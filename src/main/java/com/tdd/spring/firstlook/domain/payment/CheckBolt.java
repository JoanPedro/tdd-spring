package com.tdd.spring.firstlook.domain.payment;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id")
@JsonTypeName("CH")
public class CheckBolt extends Payment {

  @Column
  private String checkNumber;

  public CheckBolt(Long id, Double amount, String checkNumber) {
    super(id, amount);
    this.checkNumber = checkNumber;
  }

  public CheckBolt() {

  }

  public String getCheckNumber() {
    return checkNumber;
  }

  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }
}
