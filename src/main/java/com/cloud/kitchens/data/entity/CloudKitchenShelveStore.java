package com.cloud.kitchens.data.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.cloud.kitchens.data.domain.Order;
import com.cloud.kitchens.data.domain.ShelveType;

public class CloudKitchenShelveStore {

  private final Map<ShelveType, List<Order>> shelves = new HashMap<ShelveType, List<Order>>();

  public CloudKitchenShelveStore() {
    for (final ShelveType shelveType : ShelveType.values()) { 
      shelves.put(shelveType, new ArrayList<>());
    }
  }
  
  public Map<ShelveType, List<Order>> getShelves() {
    return shelves;
  }

  @Override
  public int hashCode() {
    return Objects.hash(shelves);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final CloudKitchenShelveStore other = (CloudKitchenShelveStore) obj;
    return Objects.equals(shelves, other.shelves);
  }

  
}
