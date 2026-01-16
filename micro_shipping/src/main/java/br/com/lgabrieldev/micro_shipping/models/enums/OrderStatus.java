package br.com.lgabrieldev.micro_shipping.models.enums;

public enum OrderStatus {

     //CONSTANTS
     PENDING("payment pending"),
     APPROVED("payment approved"),
     DENIED("payment denied");

     //attributes
     private String statusDescription;

     //constructors
     private OrderStatus(String statusDescription){
          this.statusDescription = statusDescription;
     }

     //getters and setters
     public String getStatusDescription(){
          return this.statusDescription;
     }

     public void setStatusDescription(String statusDescription){
          this.statusDescription = statusDescription;
     }
}
