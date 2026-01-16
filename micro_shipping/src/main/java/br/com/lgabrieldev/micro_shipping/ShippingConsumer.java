package br.com.lgabrieldev.micro_shipping;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import br.com.lgabrieldev.micro_shipping.models.Order;
import br.com.lgabrieldev.micro_shipping.rabbit_configs.RabbitConfigs;

@Service
public class ShippingConsumer {
     
     @RabbitListener(queues = RabbitConfigs.APPROVED_PAYMENT_SHIPPING_QUEUE)
     public void getMessages(Order order){
          System.out.println(String.format("Hello, '%s', your product has been shipped! Please expect delivery within the next 5 days...\n", order.getEmail()));
     }
}