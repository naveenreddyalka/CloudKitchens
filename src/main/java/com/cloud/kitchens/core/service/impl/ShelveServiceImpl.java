package com.cloud.kitchens.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloud.kitchens.core.dao.CloudKitchenDao;
import com.cloud.kitchens.core.service.ShelveService;
import com.cloud.kitchens.data.domain.Order;
import com.cloud.kitchens.data.domain.ShelveType;
import com.cloud.kitchens.data.domain.Temperature;
import com.cloud.kitchens.data.entity.CloudKitchen;

@Service
public class ShelveServiceImpl implements ShelveService {

  @Autowired private CloudKitchenDao cloudKitchenDao;

  @Override
  public Order pack(final Order order, final Integer cloudKitchenId) {

    final CloudKitchen cloudKitchen = cloudKitchenDao.getCloudKitchen(cloudKitchenId);

    
     //if(!shelve(cloudKitchen, order)) {
      // rearrange(order.getTemp(), cloudKitchen);
       final Boolean test  =shelve(cloudKitchen, order);
    // }
       
       System.out.println( "saved = " + test); 
       order.setOrderStatus(order.getOrderStatus().getNext());
       

    return order;
  }

  
  private boolean shelve(final CloudKitchen cloudKitchen,final Order order ) {
    
    for (final ShelveType shelveType : ShelveType.getShelvesForTemperature(order.getTemp())) {
      if (cloudKitchen.getCloudKitchenShelveStore().getShelves().get(shelveType).size()
              < shelveType.getMaxSize()
          && cloudKitchenDao.shelveOrder(cloudKitchen, order, shelveType)) {
        order.setOrderStatus(order.getOrderStatus().getNext());
        return true;
      }
    }
    return false;
  }
  
  private void rearrange(final Temperature temp, final CloudKitchen cloudKitchen) {

    final ShelveType shelveTypeToCheck = ShelveType.getShelveForTemperature(temp);
   
    if (cloudKitchen.getCloudKitchenShelveStore().getShelves().get(shelveTypeToCheck).size()
        < shelveTypeToCheck.getMaxSize()) {
      
      cloudKitchen.getCloudKitchenShelveStore().getShelves().get(ShelveType.OVERFLOW).forEach(
          order -> {
            cloudKitchenDao.pickUp(cloudKitchen, order);
            cloudKitchenDao.shelveOrder(cloudKitchen, order, shelveTypeToCheck);
            return;
          }
          );
    }
  }
}
