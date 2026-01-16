package br.com.lgabrieldev.micro_orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lgabrieldev.micro_orders.models.order.Order;

@RestController
@RequestMapping("/orders")
public class OrdersController {

     //attributes
     @Autowired
     public OrdersProducer ordersProducer ;
  
     @PostMapping("")
     public ResponseEntity<String> createOrder(@RequestBody Order order){
          ordersProducer.sendOrder(order);
          return ResponseEntity.ok("Order sent to the paymnent queue\n" + order.toString());
     }
}