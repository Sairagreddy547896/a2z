package com.a2z.ecommerce.customExceptions;

public class ReviiewAlreadyExistExceptiom extends  RuntimeException{

    public ReviiewAlreadyExistExceptiom(String message,Throwable cause){
        super(message,cause);
    }

    public ReviiewAlreadyExistExceptiom(String message){
        super(message);
    }

}
