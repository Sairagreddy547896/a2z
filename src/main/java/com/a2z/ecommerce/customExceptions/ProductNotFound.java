package com.a2z.ecommerce.customExceptions;

public class ProductNotFound  extends  RuntimeException{

    public ProductNotFound(String message,Throwable cause){
        super(message,cause);
    }

    public ProductNotFound(String message){
        super(message);
    }
}
