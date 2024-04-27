package com.getajob.aopdemo.aspect;

import com.getajob.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.jar.JarEntry;

@Aspect
@Component
@Order(4)
public class AddingAccountAspect {
    @Before("com.getajob.aopdemo.aspect.MyDemoLoggingAspect.testaddAccMethod()")
    public void testNoGetterSetter() {
        System.out.println("Executing before testaddAccMethod testNoGetterSetter Method");
    }



}
