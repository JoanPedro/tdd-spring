package com.tdd.spring.firstlook.domain.many_to_many;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project implements Serializable {
  private static final long serialVersionUID = 1L;

  // Inverse-Side of Relationship
  @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
  private final Set<Programmer> programmers = new HashSet<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Project() {
  }

  public Project(Long id, String name) {
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

  public Set<Programmer> getProgrammers() {
    return programmers;
  }
}


