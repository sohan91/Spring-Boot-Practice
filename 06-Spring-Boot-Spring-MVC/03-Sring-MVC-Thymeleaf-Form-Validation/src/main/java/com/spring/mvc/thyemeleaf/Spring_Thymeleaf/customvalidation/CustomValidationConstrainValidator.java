package com.spring.mvc.thyemeleaf.Spring_Thymeleaf.customvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidationConstrainValidator implements ConstraintValidator<CustomValidation, String> {

    private String prefixCode;

    @Override
    public void initialize(CustomValidation theConstraintAnnotation) {
        prefixCode = theConstraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {
           if (theCode == null) {
            return false;
        }

        return theCode.startsWith(prefixCode);
    }
}
