package br.com.lgabrieldev.micro_orders;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import br.com.lgabrieldev.micro_orders.models.order.Order;
import br.com.lgabrieldev.micro_orders.models.order.OrderDTO;
import br.com.lgabrieldev.micro_orders.rabbit_configs.RabbitConfigs;

@Service
public class OrdersProducer {
     
          //attributes
          private RabbitTemplate rabbitTemplate;

          //constructors
          public OrdersProducer(RabbitTemplate rabbitTemplate){
               this.rabbitTemplate = rabbitTemplate;
          }

          public void sendOrder(OrderDTO orderDTO){
               Order order1 = new Order();
               order1.setOrderId(orderDTO.getOrderId());
               order1.setProductName(orderDTO.getProductName());
               order1.setEmail(orderDTO.getEmail());

               System.out.println(String.format("Order '%s' received and sent to the PAYMENT PROCESSING queue...\n", order1));
               this.rabbitTemplate.convertAndSend(RabbitConfigs.ORDERS_EXCHANGE, RabbitConfigs.PAYMENT_PROCESSING_ROUTING_KEY, order1);
          }
}