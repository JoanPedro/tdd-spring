package com.tdd.spring.firstlook.domain.files;

import javax.persistence.*;

@Entity
public class Images {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Lob
  private byte[] data;

  public Images() {
  }

  public Images(Long id, String name, byte[] data) {
    this.id = id;
    this.name = name;
    this.data = data;
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

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}
