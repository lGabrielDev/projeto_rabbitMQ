package br.com.lgabrieldev.micro_payment;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import br.com.lgabrieldev.micro_payment.models.Order;
import br.com.lgabrieldev.micro_payment.models.enums.OrderStatus;
import br.com.lgabrieldev.micro_payment.rabbit_configs.RabbitConfigs;

@Service
public class PaymentConsumer {

     //attributes
     private PaymentProducer paymentProducer;

     //constructors
     public PaymentConsumer(PaymentProducer paymentProducer){
          this.paymentProducer = paymentProducer;
     }

     @RabbitListener(queues = RabbitConfigs.PAYMENT_PROCESSING_QUEUE)
     public void getOrderFromPaymentProcessingQueue(Order order){
     System.out.println(String.format("Payment microservice received the order... Let's analyze this order..."));

          //processa o pagamento.....................
          //verifica fraude............
          //etc.......

          //alteramos o status do pedido e salvamos no banco
          order.setOrderStatus(OrderStatus.APPROVED);

          //enviamos pra fila de NOTIFICATION e fila de SHIPPING
          System.out.println(String.format("Order '%s' approved and sent to the notification queue...\n", order));
          System.out.println(String.format("Order '%s' approved and sent to the shipping queue...\n", order));

          paymentProducer.sendOrderPaymentApproved(order);
     }
}