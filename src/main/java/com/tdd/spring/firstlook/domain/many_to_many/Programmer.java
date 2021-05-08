package com.tdd.spring.firstlook.domain.many_to_many;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Programmer implements Serializable {
  private static final long serialVersionUID = 1L;

  /*
                              JOIN TABLE
                  |-----------------|--------------|
  Join Column ==> | programmer_id   |   project_id | <== Inverse Column
   Foreign Key    |-----------------|--------------|      Foreign Key
        of        |       1         |       2      |          of
    Programmer    |       2         |       2      |        Project
                  |       3         |       1      |
                  |       3         |       2      |
                  |-----------------|--------------|
   */
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "programmers_projects",
      joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id")
  )
  private final Set<Project> projects = new HashSet<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double salary;

  public Programmer() {
  }

  public Programmer(Long id, String name, Double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
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

  public Double getSalary() {
    return this.salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Set<Project> getProjects() {
    return projects;
  }

  public void addProjects(Iterable<Project> projects) {
    projects.forEach(project -> {
      this.getProjects().add(project);
      project.getProgrammers().add(this);
    });
  }
}
