package com.getajob.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AddingAccountOneParamAspect {
    @Before("com.getajob.aopdemo.aspect.MyDemoLoggingAspect.testAddAccOneParamMethod()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Executing before testAddAccOneParamMethod beforeAddAccountAdvice Method" + methodSignature);

        Object[] a= joinPoint.getArgs();

        for(Object s: a){
            System.out.println(s);
        }
    }
}
