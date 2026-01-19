package br.com.lgabrieldev.micro_orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lgabrieldev.micro_orders.models.order.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/orders")
@Tag(name = "orders controller")
public class OrdersController {

     //attributes
     @Autowired
     public OrdersProducer ordersProducer ;
  
     @Operation(description = "Cria um pedido")
     @ApiResponses( value = { //criamos as possiveis responses
            @ApiResponse(responseCode = "201 Created", description = "Pedido criado com sucesso!"),
          }
     )
     @PostMapping("")
     public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){
          ordersProducer.sendOrder(orderDTO);
          return ResponseEntity.status(HttpStatus.CREATED).body("Order sent to the paymnent queue\n" + orderDTO.toString());
     }
}