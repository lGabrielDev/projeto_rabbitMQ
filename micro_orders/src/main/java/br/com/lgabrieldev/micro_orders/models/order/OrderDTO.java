package br.com.lgabrieldev.micro_orders.models.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDTO {

     //attributes
     private Long  orderId;
     private String productName;
     private String email;
}
