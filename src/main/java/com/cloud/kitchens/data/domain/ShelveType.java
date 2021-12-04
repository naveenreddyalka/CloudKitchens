package com.cloud.kitchens.data.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ShelveType {
  HOT(10, Temperature.hot),
  COLD(10, Temperature.cold),
  FROZEN(10, Temperature.frozen),
  OVERFLOW(15, Temperature.hot, Temperature.cold, Temperature.frozen);

  private final List<Temperature> allowed;
  private final Integer maxSize;
  private static final Map<Temperature,List<ShelveType>> shelvesForTemperature = new HashMap<Temperature, List<ShelveType>>();

  private ShelveType(final Integer maxSize, final Temperature... allowed) {
    this.maxSize = maxSize;
    this.allowed = List.of(allowed);
  }

  public List<Temperature> getAllowed() {
    return allowed;
  }

  public Integer getMaxSize() {
    return maxSize;
  }
  
  public static List<ShelveType> getShelvesForTemperature(final Temperature temp) {
    final List<ShelveType> shelveTypes = new ArrayList<ShelveType>();
    
    switch (temp) {
      case hot:
        shelveTypes.add(ShelveType.HOT);
        break;
      case cold:
        shelveTypes.add(ShelveType.COLD);
        break;
      case frozen:
        shelveTypes.add(ShelveType.FROZEN);
        break;

      default:
        break;
    }
    shelveTypes.add(ShelveType.OVERFLOW);
    return shelveTypes;
  }

  public static ShelveType getShelveForTemperature(final Temperature temp) {

    switch (temp) {
      case hot:
        return HOT;
      case cold:
        return COLD;
      case frozen:
        return FROZEN;
    }
    
    return null;
  }
  
  
  
}
