package com.example.vendas.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiError {
    private List<String> errors;

    public ApiError(String msg) {
        this.errors = Arrays.asList(msg);
    }

    public ApiError(List<String> errors) {
        this.errors = errors;
    }
}
