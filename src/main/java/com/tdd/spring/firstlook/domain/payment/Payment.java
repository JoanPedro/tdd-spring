package com.tdd.spring.firstlook.domain.payment;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Define witch column will be used to map inheritance
@DiscriminatorColumn(name = "paymentMethod", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private Long id;

  private Double amount;

  Payment() {
  }

  Payment(Long id, Double amount) {
    this.id = id;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
