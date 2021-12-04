package com.cloud.kitchens.core.service;

import com.cloud.kitchens.data.domain.Order;

public interface KitchenService {

  public Order cook(final Order order,Integer cloudKitchenId);
  
}
