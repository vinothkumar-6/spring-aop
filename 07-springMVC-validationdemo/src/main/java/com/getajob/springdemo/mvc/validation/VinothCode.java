package com.getajob.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = VinothCodeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VinothCode {

    public String value() default "VINO";

    public String message() default "must start with VINO";

    public Class<?>[] groups() default {};

   // public Class<? extends Payload>[] payload() default {};
    public Class<? extends Payload>[] payload() default {};

}
