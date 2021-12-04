package com.cloud.kitchens.core.service.impl;

import org.springframework.stereotype.Service;
import com.cloud.kitchens.core.service.KitchenService;
import com.cloud.kitchens.data.domain.Order;

@Service
public class KitchenServiceImpl implements KitchenService {
  
  @Override
  public Order cook(final Order order,final Integer cloudKitchenId) {
    order.setOrderStatus(order.getOrderStatus().getNext());
    return order;
  }
}
