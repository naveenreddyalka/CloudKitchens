package com.cloud.kitchens.data.domain;

public enum ResponseCode {
  SUCCESS(999),
  FAILED(0),

  ORDER_NOT_COOKED(101),
  ORDER_EXPIRED(102);

  private final Integer code;

  private ResponseCode(final Integer code) {
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
