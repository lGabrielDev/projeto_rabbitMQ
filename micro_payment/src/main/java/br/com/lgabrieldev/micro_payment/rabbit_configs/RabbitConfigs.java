package br.com.lgabrieldev.micro_payment.rabbit_configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigs {
     
     //constants
     public static final String PAYMENT_PROCESSING_QUEUE="payment_processing_queue";  // created by Order microservice
     
     public static final String PAYMENT_EXCHANGE="payment_exchange";
     public static final String APPROVED_PAYMENT_SHIPPING_QUEUE = "approved_payment_shipping_queue"; 
     public static final String APPROVED_PAYMENT_NOTIFICATION_QUEUE = "approved_payment_notification_queue";

     @Bean
     public FanoutExchange generatePaymentExchange(){
          return new FanoutExchange(PAYMENT_EXCHANGE);
     } 

     @Qualifier(APPROVED_PAYMENT_SHIPPING_QUEUE)
     @Bean
     public Queue generateApprovedPaymentQueue(){
          return new Queue(APPROVED_PAYMENT_SHIPPING_QUEUE);
     } 

     @Bean
     public Binding generatePaymentProcessingQueueBinding(@Qualifier(APPROVED_PAYMENT_SHIPPING_QUEUE) Queue queue, FanoutExchange exchange){
          return BindingBuilder
               .bind(queue)
               .to(exchange);
     }

     @Qualifier(APPROVED_PAYMENT_NOTIFICATION_QUEUE)
     @Bean
     public Queue generateOrderStatusNotificationQueue(){
          return new Queue(APPROVED_PAYMENT_NOTIFICATION_QUEUE);
     } 

     @Bean
     public Binding generateOrderStatusUpdateQueueBinding(@Qualifier(APPROVED_PAYMENT_NOTIFICATION_QUEUE) Queue queue, FanoutExchange exchange){
          return BindingBuilder
               .bind(queue)
               .to(exchange);
     }

    @Bean
     public MessageConverter JsonToJavaConverter(){
          return new JacksonJsonMessageConverter();
     }
}