package com.cloud.kitchens.core.event;

import java.time.Clock;
import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class OrderEvent extends ApplicationEvent {

  public OrderEvent(final Object source, final Clock clock) {
    super(source, clock);
  }
}
