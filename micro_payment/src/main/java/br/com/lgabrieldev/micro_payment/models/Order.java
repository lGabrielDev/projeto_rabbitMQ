package br.com.lgabrieldev.micro_payment.models;

import br.com.lgabrieldev.micro_payment.models.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
     
     //attributes
     private Long  orderId;
     private String productName;
     private String email;
     private OrderStatus orderStatus;

     //constructors
     public Order(){
          this.orderStatus = OrderStatus.PENDING;
     }
}