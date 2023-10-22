package com.chalana.taskappbackend.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


//    @ExceptionHandler(Throwable.class)
//    public Map<String , Object> uncaughtExceptions( Throwable t){
//        t.printStackTrace();
//        LinkedHashMap<String, Object> errAttributes = new LinkedHashMap<>();
//        errAttributes.put("status", HttpStatus.valueOf(405));
////        errAttributes.put("error",t.getCause());
//        errAttributes.put("message",t.getMessage());
//        return errAttributes ;
//
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> validationExceptions(MethodArgumentNotValidException exp) {
        LinkedHashMap<String, Object> errAttributes = new LinkedHashMap<>();
        errAttributes.put("status",HttpStatus.BAD_REQUEST.value());
        errAttributes.put("error",HttpStatus.BAD_REQUEST.getReasonPhrase());
        errAttributes.put("timestamp", new Date().toString());
        List<String> validationErrList = exp.getFieldErrors().stream().map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
        errAttributes.put("errors",validationErrList);
        return errAttributes ;
    }



}
