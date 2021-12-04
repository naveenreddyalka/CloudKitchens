package com.cloud.kitchens.core.service.impl;

import java.util.Date;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import com.cloud.kitchens.commons.CloudKitchensTime;
import com.cloud.kitchens.core.dao.CloudKitchenDao;
import com.cloud.kitchens.core.event.OrderEvent;
import com.cloud.kitchens.core.service.DeliveryService;
import com.cloud.kitchens.data.request.OrderRequest;

@Service
public class DeliveryServiceImpl implements DeliveryService {

  private static final Logger log = LoggerFactory.getLogger(DeliveryServiceImpl.class);

  @Autowired private CloudKitchenDao cloudKitchenDao;

  @Override
  @EventListener
  public void deliver(final OrderEvent ordervent)  {
    final OrderRequest orderRequest = ((OrderRequest) ordervent.getSource());
    final Random rand = new Random();
    
   try {
     Thread.sleep( (rand.nextInt(5) +2) * 1000);
   } catch (final InterruptedException e){// TODO Auto-generated catch block
  e.printStackTrace();}
    
   final Boolean pickup =  cloudKitchenDao.pickUp(
        cloudKitchenDao.getCloudKitchen(orderRequest.getCloudKitchenId()), orderRequest.getOrder());
  
   log.info(
       "Delivering OrderId:{} at {} was {}",
       ((OrderRequest) ordervent.getSource()).getOrder().getId(),
       CloudKitchensTime.dateFormat.format(new Date()), pickup?"SUCCESS":"FAILURE");

   
  }
}
