package com.cloud.kitchens.core.controller;

import java.time.Clock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import com.cloud.kitchens.core.event.OrderEvent;
import com.cloud.kitchens.core.service.KitchenService;
import com.cloud.kitchens.core.service.ShelveService;
import com.cloud.kitchens.data.domain.Order;
import com.cloud.kitchens.data.domain.OrderStatus;
import com.cloud.kitchens.data.domain.ResponseCode;
import com.cloud.kitchens.data.request.OrderRequest;
import com.cloud.kitchens.data.response.OrderResponse;

@Service
public class OrderController {

  @Autowired private ApplicationEventPublisher publisher;

  @Autowired private KitchenService kitchenService;

  @Autowired  private ShelveService shelveService;
  
  public OrderResponse process(final OrderRequest orderRequest) {
    
    final Order order = orderRequest.getOrder();
    order.setOrderStatus(OrderStatus.PLACED);

    final Thread t = new Thread(()->publisher.publishEvent(new OrderEvent(orderRequest, Clock.systemUTC())));
    
    t.start();
     
    kitchenService.cook(order,orderRequest.getCloudKitchenId());
    
    shelveService.pack(order,orderRequest.getCloudKitchenId());
    
    
    
    return new OrderResponse(ResponseCode.SUCCESS);
  }
  
  
  
}
