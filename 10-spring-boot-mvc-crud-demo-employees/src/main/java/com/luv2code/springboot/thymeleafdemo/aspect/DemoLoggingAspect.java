package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){

    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forCombined(){

    }

    @Before("forCombined()")
    public void before(JoinPoint joinPoint){
               String method = joinPoint.getSignature().toShortString();
               myLogger.info("@Before Advice: "+method);

               Object[] obj = joinPoint.getArgs();
               for(Object o: obj){
                   myLogger.info("Object : "+o);
               }
    }

    @AfterReturning(pointcut ="forCombined()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("@AfterReturning Advice: "+method);

        myLogger.info("result     "+ result );
    }

}
