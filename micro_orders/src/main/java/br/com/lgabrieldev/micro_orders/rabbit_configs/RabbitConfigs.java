package br.com.lgabrieldev.micro_orders.rabbit_configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigs {

     //constants
     public static final String ORDERS_EXCHANGE="orders_exchange";
     public static final String PAYMENT_PROCESSING_QUEUE="payment_processing_queue"; 
     public static final String PAYMENT_PROCESSING_ROUTING_KEY="payment_processing_routing_key";

     @Bean
     public DirectExchange generateOrdersExchange(){
          return new DirectExchange(ORDERS_EXCHANGE);
     } 

     @Bean
     public Queue generatePaymentProcessingQueue(){
          return new Queue(PAYMENT_PROCESSING_QUEUE);
     } 

     @Bean
     public Binding generatePaymentProcessingBinding(Queue queue, DirectExchange exchange){
          return BindingBuilder
               .bind(queue)
               .to(exchange)
               .with(PAYMENT_PROCESSING_ROUTING_KEY);
     }

     // O conversor padrão do Spring Boot para RabbitMQ é o "SimpleMessageConverter" --> Só trabalha com String ou byte[]
     // Por isso precisamos alterar
     @Bean 
     public MessageConverter JsonToJavaConverter(){
          return new JacksonJsonMessageConverter();
     }
}