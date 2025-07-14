package com.spring.mvc.thyemeleaf.Spring_Thymeleaf.customvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CustomValidationConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomValidation {

    String value() default "myCode";

    String message() default "must start with myCode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
