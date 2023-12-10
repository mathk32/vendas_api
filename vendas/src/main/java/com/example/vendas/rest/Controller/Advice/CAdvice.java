package com.example.vendas.rest.Controller.Advice;

import com.example.vendas.rest.ApiError;
import com.example.vendas.rest.Exceptions.RegraDeNegocios;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CAdvice {

    @ExceptionHandler(RegraDeNegocios.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError Exception_Handler(RegraDeNegocios ex){
        String msg = ex.getMessage();
        return new ApiError(msg);
    }
}
