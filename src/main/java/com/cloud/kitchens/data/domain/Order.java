package com.cloud.kitchens.data.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"orderStatus"})
public class Order {

  private String id;
  private String name;
  private Temperature temp;
  private Integer shelfLife;
  private Double decayRate;
  
  @JsonIgnore
  private OrderStatus orderStatus;

  public Order() {
    super();
  }

  public Order(
      final String id,
      final String name,
      final Temperature temp,
      final Integer shelfLife,
      final Double decayRate) {
    super();
    this.id = id;
    this.name = name;
    this.temp = temp;
    this.shelfLife = shelfLife;
    this.decayRate = decayRate;
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Temperature getTemp() {
    return temp;
  }

  public void setTemp(final Temperature temp) {
    this.temp = temp;
  }

  public Integer getShelfLife() {
    return shelfLife;
  }

  public void setShelfLife(final Integer shelfLife) {
    this.shelfLife = shelfLife;
  }

  public Double getDecayRate() {
    return decayRate;
  }

  public void setDecayRate(final Double decayRate) {
    this.decayRate = decayRate;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(final OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final Order other = (Order) obj;
    return Objects.equals(id, other.id);
  }

  @Override
  public String toString() {
    return "Order [id="
        + id
        + ", name="
        + name
        + ", temp="
        + temp
        + ", shelfLife="
        + shelfLife
        + ", decayRate="
        + decayRate
        + "]";
  }
}
