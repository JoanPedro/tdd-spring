package com.tdd.spring.firstlook.domain.steps;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order2 {

  @OneToMany(
      mappedBy = "order",
      cascade = CascadeType.ALL
  )
  private final List<Order2Item> items = new ArrayList<>();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Instant moment;
  private Order2Status status;

  @ManyToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client2 client;

  public Order2() {
  }

  public Order2(Long id, Instant moment, Order2Status status, Client2 client) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Order2Item> getItems() {
    return items;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public Order2Status getStatus() {
    return status;
  }

  public void setStatus(Order2Status status) {
    this.status = status;
  }

  public Client2 getClient() {
    return client;
  }

  public void setClient(Client2 client) {
    this.client = client;
  }

  public void addOrders(Iterable<Order2Item> orders) {
    orders.forEach(order -> {
      getItems().add(order);
    });
  }
}
