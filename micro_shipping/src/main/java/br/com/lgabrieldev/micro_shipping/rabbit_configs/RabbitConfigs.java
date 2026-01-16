package br.com.lgabrieldev.micro_shipping.rabbit_configs;

import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class RabbitConfigs {
     public static final String APPROVED_PAYMENT_SHIPPING_QUEUE = "approved_payment_shipping_queue";  // created by Payment microservice

     @Bean
     public MessageConverter JsonToJavaConverter(){
          return new JacksonJsonMessageConverter();
     }
}