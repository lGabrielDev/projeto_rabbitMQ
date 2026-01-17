package br.com.lgabrieldev.micro_orders;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import br.com.lgabrieldev.micro_orders.models.order.Order;
import br.com.lgabrieldev.micro_orders.rabbit_configs.RabbitConfigs;

@Service
public class OrdersProducer {
     
          //attributes
          private RabbitTemplate rabbitTemplate;

          //constructors
          public OrdersProducer(RabbitTemplate rabbitTemplate){
               this.rabbitTemplate = rabbitTemplate;
          }

          public void sendOrder(Order order){
               System.out.println(String.format("Order '%s' received and sent to the PAYMENT PROCESSING queue...\n", order));
               this.rabbitTemplate.convertAndSend(RabbitConfigs.ORDERS_EXCHANGE, RabbitConfigs.PAYMENT_PROCESSING_ROUTING_KEY, order);
          }
}