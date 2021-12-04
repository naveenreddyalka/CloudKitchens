package com.cloud.kitchens.core.dao;

import org.springframework.stereotype.Repository;
import com.cloud.kitchens.commons.CloudKitchenDB;
import com.cloud.kitchens.data.domain.Order;
import com.cloud.kitchens.data.domain.ShelveType;
import com.cloud.kitchens.data.entity.CloudKitchen;

@Repository
public class CloudKitchenDao {

  public CloudKitchen getCloudKitchen(final Integer id) {
    return CloudKitchenDB.cloudKitchens.get(id);
  }

  public Boolean shelveOrder(
      final CloudKitchen cloudKitchen, final Order order, final ShelveType shelveType) {
    synchronized (cloudKitchen) {
      if (cloudKitchen.equals(CloudKitchenDB.cloudKitchens.get(cloudKitchen.getId()))) {
        cloudKitchen.getCloudKitchenShelveStore().getShelves().get(shelveType).add(order);
        return true;
      }
      return false;
    }
  }

  public Boolean pickUp(final CloudKitchen cloudKitchen, final Order order) {

    for (final ShelveType shelveType : ShelveType.getShelvesForTemperature(order.getTemp())) {
      if (cloudKitchen.getCloudKitchenShelveStore().getShelves().get(shelveType).contains(order)) {
        cloudKitchen.getCloudKitchenShelveStore().getShelves().get(shelveType).remove(order);
        return true;
      }
    }

    return false;
  }
}
