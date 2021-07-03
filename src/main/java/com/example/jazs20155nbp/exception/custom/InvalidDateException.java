package com.example.jazs20155nbp.exception.custom;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String date){
        super(date + " is not valid");
    }
}
