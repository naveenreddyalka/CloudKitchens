package com.cloud.kitchens.core.service;

import com.cloud.kitchens.data.domain.Order;

public interface ShelveService {
  
  public Order pack(Order order,Integer cloudKitchenId);
}
