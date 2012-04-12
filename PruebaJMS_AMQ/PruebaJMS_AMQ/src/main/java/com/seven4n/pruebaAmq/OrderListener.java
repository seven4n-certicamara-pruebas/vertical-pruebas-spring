package com.seven4n.pruebaAmq;

import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    public void orderReceived(Map<String, Object> message) throws Exception {
        int orderId = (Integer) message.get("orderId");
        int customerId = (Integer) message.get("customerId");
        double price = (Double) message.get("price");
        String orderCode = (String) message.get("orderCode");
        Order customer = new Order(orderId, customerId, price, orderCode);
        System.out.println("Order received: "+ orderId + ", customerId: "+ customerId + ", price: "+ price);
      }
}
