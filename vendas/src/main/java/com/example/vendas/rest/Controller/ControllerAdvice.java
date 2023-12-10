package com.example.vendas.rest.Controller;


import com.example.vendas.rest.ApiError;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RegraDeNegocios.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError ExceptionsHandler(RegraDeNegocios ex){
        String msg_error = ex.getMessage();
        return new ApiError(msg_error);
    }
}
