package com.a2z.ecommerce.customExceptions;


public class CustomerNotFound extends   RuntimeException{

     public CustomerNotFound(String message,Throwable cause){
         super(message,cause);
     }

    public CustomerNotFound(String message){
            super(message);
    }

}
