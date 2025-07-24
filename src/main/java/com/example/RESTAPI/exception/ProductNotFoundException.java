package com.example.RESTAPI.exception;

public class ProductNotFoundException extends RuntimeException{
 public ProductNotFoundException(String message){
     super(message);
 }
}
