package com.example.vendas.rest.valiation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = NotEmptyListValidator.class)
public @interface NotEmptyList {
    String message() default "Não pode ser uma lista vazia";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
