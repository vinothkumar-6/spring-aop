package com.getajob.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VinothCodeConstraintValidator implements ConstraintValidator<VinothCode, String> {

    private String vinoPrefix;

    @Override
    public void initialize(VinothCode theVinothCode) {
        vinoPrefix = theVinothCode.value();
    }

    @Override
    public boolean isValid(String theVinothCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result;
        if(theVinothCode !=null){
            result = theVinothCode.startsWith(vinoPrefix);
        } else{
            result =true;
        }
        return result;
    }
}
