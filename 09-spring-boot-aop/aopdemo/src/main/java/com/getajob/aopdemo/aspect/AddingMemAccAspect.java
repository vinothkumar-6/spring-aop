package com.getajob.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AddingMemAccAspect {
    @Before("com.getajob.aopdemo.aspect.MyDemoLoggingAspect.testAddMemAccMethod()")
    public void fancyAdvice() {
        System.out.println("Executing before testAddAccOneParamMethod AddingMemAccAspect Method");
    }

}
