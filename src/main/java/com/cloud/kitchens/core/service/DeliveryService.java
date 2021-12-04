package com.cloud.kitchens.core.service;

import com.cloud.kitchens.core.event.OrderEvent;

public interface DeliveryService {

  public void deliver(final OrderEvent ordervent);
  
}
