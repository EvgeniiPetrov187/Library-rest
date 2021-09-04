package com.petrov.controller;

public class BadRequestException extends Throwable {
    public BadRequestException(String msg){
        super(msg);
    }
}
