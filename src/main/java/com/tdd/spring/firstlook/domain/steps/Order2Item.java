package com.tdd.spring.firstlook.domain.steps;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_orderitem")
public class Order2Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer quantity;
  private Double price;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product2 product;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private Order2 order;

  public Order2Item() {
  }

  public Order2Item(Long id, Integer quantity, Double price, Product2 product, Order2 order) {
    this.id = id;
    this.quantity = quantity;
    this.price = price;
    this.product = product;
    this.order = order;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Product2 getProduct() {
    return product;
  }

  public void setProduct(Product2 product) {
    this.product = product;
  }

  public Order2 getOrder() {
    return order;
  }

  public void setOrder(Order2 order) {
    this.order = order;
  }
}
