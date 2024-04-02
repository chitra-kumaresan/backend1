package com.example.Online_Bus_Reservation_Project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ToDoApiException extends  RuntimeException{
    private HttpStatus status;
    private  String message;

}