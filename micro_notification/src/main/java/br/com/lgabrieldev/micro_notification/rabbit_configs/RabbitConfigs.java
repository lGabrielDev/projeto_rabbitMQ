package br.com.lgabrieldev.micro_notification.rabbit_configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class RabbitConfigs {

     //constants
     public static final String APPROVED_PAYMENT_NOTIFICATION_QUEUE = "approved_payment_notification_queue"; // created by Payment microservice

     //criamos essa fila só em caso do microservice 'Payment' nao subir primeiro
     @Bean
     public Queue generateQueue(){
          return new Queue(APPROVED_PAYMENT_NOTIFICATION_QUEUE);
     } 
   
   
     @Bean
     public MessageConverter JsonToJavaConverter(){
          return new JacksonJsonMessageConverter();
     }
}