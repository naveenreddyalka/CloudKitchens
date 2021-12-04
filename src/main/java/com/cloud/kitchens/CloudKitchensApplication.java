package com.cloud.kitchens;

import java.io.IOException;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.cloud.kitchens.commons.CloudKitchensTime;
import com.cloud.kitchens.core.controller.OrderController;
import com.cloud.kitchens.data.domain.Order;
import com.cloud.kitchens.data.request.BulkOrderRequest;
import com.cloud.kitchens.data.request.OrderRequest;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableScheduling
@EnableAsync(proxyTargetClass = true)
public class CloudKitchensApplication {

  private static final Logger log = LoggerFactory.getLogger(CloudKitchensApplication.class);
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Value("classpath:orders.json")
  private Resource resourceFile;

  @Autowired
  private OrderController orderController;
  
  private BulkOrderRequest bulkOrderRequest;
  private Integer currentOrderIndex = 0;
  private final Integer cloudKitchenId = 1;

  public static void main(final String[] args) {
    SpringApplication.run(CloudKitchensApplication.class, args);
  }

  @PostConstruct
  private void init() throws StreamReadException, DatabindException, IOException {
    bulkOrderRequest =
        objectMapper.readValue(resourceFile.getInputStream(), BulkOrderRequest.class);
  }

  @Scheduled(fixedRate = 500)
  public void reportCurrentTime() {
    if (bulkOrderRequest.getOrders().size() > currentOrderIndex + 1) {
      final Order order = bulkOrderRequest.getOrders().get(currentOrderIndex);
      
      log.info(
          "Processing OrderId:{} at {}", order, CloudKitchensTime.dateFormat.format(new Date()));
     
      orderController.process(new OrderRequest(order,cloudKitchenId));
    }
    currentOrderIndex++;
  }
}
