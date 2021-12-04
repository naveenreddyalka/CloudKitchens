package com.cloud.kitchens.data.entity;

import java.util.Objects;

public class CloudKitchen {

  private final Integer id;
  private final CloudKitchenShelveStore cloudKitchenShelveStore;

  public CloudKitchen(final Integer id, final CloudKitchenShelveStore cloudKitchenShelveStore) {
    super();
    this.id = id;
    this.cloudKitchenShelveStore = cloudKitchenShelveStore;
  }

  public Integer getId() {
    return id;
  }

  public CloudKitchenShelveStore getCloudKitchenShelveStore() {
    return cloudKitchenShelveStore;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudKitchenShelveStore, id);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final CloudKitchen other = (CloudKitchen) obj;
    return Objects.equals(cloudKitchenShelveStore, other.cloudKitchenShelveStore)
        && Objects.equals(id, other.id);
  }
  
  
}
