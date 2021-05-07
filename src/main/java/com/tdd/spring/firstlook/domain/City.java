package com.tdd.spring.firstlook.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class City implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GenericGenerator(name = "city_id", strategy = "com.tdd.spring.firstlook.domain.IdGenerators")
  @GeneratedValue(generator = "city_id")
  private Long id;

  private String name;

  public City() {

  }

  public City(Long id, String name) {
    this.id = id;
    this.name = name;
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
