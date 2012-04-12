package com.seven4n.pruebaAmq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class OrderSender {
   
    @Autowired
    private JmsTemplate jmsTemplate;
   
    public void sendOrder(final Order order){
        jmsTemplate.send(
        new MessageCreator() {
          public Message createMessage(Session session) throws JMSException {
               MapMessage mapMessage = session.createMapMessage();
               mapMessage.setInt("orderId", order.getOrderId());
               mapMessage.setInt("customerId", order.getCustomerId());
               mapMessage.setDouble("price", order.getPrice());
               mapMessage.setString("orderCode", order.getOrderCode());
               return mapMessage;
          }
        }
        );
        System.out.println("Order sent - id: "+ order.getOrderId());
    }
}
