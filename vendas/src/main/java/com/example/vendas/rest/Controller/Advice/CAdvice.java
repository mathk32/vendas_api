package com.example.vendas.rest.Controller.Advice;

import com.example.vendas.rest.ApiError;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class CAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError ExceptionMethodNotValid_Handler(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiError(errors);
    }

    @ExceptionHandler(RegraDeNegocios.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError ExceptionNotFound_Handler(RegraDeNegocios ex){
        String msg = ex.getMessage();
        return new ApiError(msg);
    }




}
