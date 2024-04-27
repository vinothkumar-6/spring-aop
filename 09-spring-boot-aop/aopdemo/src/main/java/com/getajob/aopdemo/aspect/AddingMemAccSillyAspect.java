package com.getajob.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AddingMemAccSillyAspect {
    @Before("com.getajob.aopdemo.aspect.MyDemoLoggingAspect.testAddMemAccSillyMethod()")
    public void fancySillyAdvice() {
        System.out.println("Executing before testAddMemAccSillyMethod fancySillyAdvice Method");
    }
}
