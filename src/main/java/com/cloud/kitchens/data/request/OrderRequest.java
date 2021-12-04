package com.cloud.kitchens.data.request;

import java.io.Serializable;
import java.util.Objects;
import com.cloud.kitchens.data.domain.Order;

public class OrderRequest implements Serializable {

  private static final long serialVersionUID = 6779398495154282021L;

  private Order order;

  private int cloudKitchenId;

  public OrderRequest() {
    super();
  }

  public OrderRequest(final Order order, final int cloudKitchenId) {
    super();
    this.order = order;
    this.cloudKitchenId = cloudKitchenId;
  }

  public int getCloudKitchenId() {
    return cloudKitchenId;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Order getOrder() {
    return order;
  }

  @Override
  public int hashCode() {
    return Objects.hash(order);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final OrderRequest other = (OrderRequest) obj;
    return Objects.equals(order, other.order);
  }
}
