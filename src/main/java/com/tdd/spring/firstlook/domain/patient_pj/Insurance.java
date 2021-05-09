package com.tdd.spring.firstlook.domain.patient_pj;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Insurance implements Serializable {
  private static final long serialVersionUID = 1L;

  private String providerName;
  private Double copay;

  public Insurance() {
  }

  public Insurance(String providerName, Double copay) {
    this.providerName = providerName;
    this.copay = copay;
  }

  public String getProviderName() {
    return providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public Double getCopay() {
    return copay;
  }

  public void setCopay(Double copay) {
    this.copay = copay;
  }

  @Override
  public String toString() {
    return "Insurance{" +
        "providerName='" + providerName + '\'' +
        ", copay=" + copay +
        '}';
  }
}
