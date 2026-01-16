package br.com.lgabrieldev.micro_notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import br.com.lgabrieldev.micro_notification.models.Order;
import br.com.lgabrieldev.micro_notification.rabbit_configs.RabbitConfigs;

@Service
public class NotificationConsumer {

     @RabbitListener(queues = RabbitConfigs.APPROVED_PAYMENT_NOTIFICATION_QUEUE)
     public void getMessages(Order order){
          System.out.println(String.format("Payment confirmation email sent to '%s'\n", order.getEmail()));
     }
}