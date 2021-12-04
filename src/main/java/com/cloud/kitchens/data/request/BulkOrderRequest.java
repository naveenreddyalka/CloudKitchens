package com.cloud.kitchens.data.request;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import com.cloud.kitchens.data.domain.Order;

public class BulkOrderRequest implements Serializable {

  private static final long serialVersionUID = 6779398495154282020L;

  private List<Order> orders;

  public BulkOrderRequest() {
    super();
  }

  public BulkOrderRequest(final List<Order> orders) {
    super();
    this.orders = orders;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(final List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orders);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final BulkOrderRequest other = (BulkOrderRequest) obj;
    return Objects.equals(orders, other.orders);
  }
}
