package com.tdd.spring.firstlook.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Column(name = "description")
  private String desc;

  private Double price;

  public Product(Integer id, String name, String desc, Double price) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.price = price;
  }

  public Product() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
