package br.com.lgabrieldev.micro_payment;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import br.com.lgabrieldev.micro_payment.models.Order;
import br.com.lgabrieldev.micro_payment.rabbit_configs.RabbitConfigs;

@Service
public class PaymentProducer {
     
     //attributes
     private RabbitTemplate rabbitTemplate;

     //constructors
     public PaymentProducer(RabbitTemplate rabbitTemplate){
          this.rabbitTemplate = rabbitTemplate;
     }

     public void sendOrderPaymentApproved(Order order){
          //vamos enviar para 2 filas:
          // approved payment notification queue
          // approved payment shipping queue
          this.rabbitTemplate.convertAndSend(RabbitConfigs.PAYMENT_EXCHANGE, "", order);
     }  
}