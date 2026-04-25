package com.club.sociosclub.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = DniValidator.class)
@Documented
public @interface DniValido {
    String message() default "{socio.dni.valido}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
