package com.cloud.kitchens.data.domain;

public enum OrderStatus {
  CLOSED(null),
  COMPLETED(CLOSED),
  DELIVERED(COMPLETED),
  PICKEDUP(DELIVERED),
  SHELVED(PICKEDUP),
  COOKED(PICKEDUP),
  PLACED(COOKED);

  private final OrderStatus next;

  private OrderStatus(final OrderStatus next) {
    this.next = next;
  }

  public OrderStatus getNext() {
    if (this == CLOSED) throw new RuntimeException("CLOSED is a terminal state");
    return this.next;
  }
}
