package com.cloud.kitchens.data.response;

import java.io.Serializable;
import java.util.Objects;
import com.cloud.kitchens.data.domain.ResponseCode;

public class OrderResponse implements Serializable {

  private static final long serialVersionUID = 6779398495154282022L;

  private ResponseCode code;

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final OrderResponse other = (OrderResponse) obj;
    return code == other.code;
  }

  public OrderResponse(final ResponseCode code) {
    super();
    this.code = code;
  }

  public ResponseCode getCode() {
    return code;
  }

  public void setCode(final ResponseCode code) {
    this.code = code;
  }
}
