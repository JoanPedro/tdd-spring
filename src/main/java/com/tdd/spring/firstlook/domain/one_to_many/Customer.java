package com.tdd.spring.firstlook.domain.one_to_many;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;

  // EAGER: WILL JOIN THE ASSOCIATION IN ADVANCE.
  // LAZY: ONLY JOIN THE ASSOCIATION WHEN GET PHONE_NUMBERS WAS CALLED. (DEFAULT)

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private final Set<PhoneNumber> phoneNumbers = new HashSet<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Customer() {
  }

  public Customer(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Set<PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
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

  public void addPhoneNumbers(Iterable<PhoneNumber> pNumbers) {
    pNumbers.forEach(phoneNumber -> {
      this.getPhoneNumbers().add(phoneNumber);
      phoneNumber.setCustomer(this);
    });
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(id, customer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
