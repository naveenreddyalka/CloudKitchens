package com.cloud.kitchens.commons;

import java.util.HashMap;
import java.util.Map;
import com.cloud.kitchens.data.entity.CloudKitchen;
import com.cloud.kitchens.data.entity.CloudKitchenShelveStore;

public class CloudKitchenDB {

  public static final CloudKitchen cloudKitchen_1 =
      new CloudKitchen(1, new CloudKitchenShelveStore());
  public static final CloudKitchen cloudKitchen_2 =
      new CloudKitchen(2, new CloudKitchenShelveStore());

  public static final Map<Integer, CloudKitchen> cloudKitchens =
      new HashMap<Integer, CloudKitchen>();

  static {
    cloudKitchens.put(1, cloudKitchen_1);
    cloudKitchens.put(2, cloudKitchen_2);
  }
}
