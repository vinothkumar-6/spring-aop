package com.getajob.aopdemo.aspect;

import com.getajob.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // @Before("execution(public void com.getajob.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void addAccount())")
    //@Before("execution(public void ad*S*())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*())")

    // @Before("execution(* com.getajob.aopdemo.dao.*.*(..))")


//    @Pointcut("execution(* com.getajob.aopdemo.dao.*.*(..))")
//    public void forDAOPackage(){
//    }
//
//   // @Before("forDAOPackage()")
//  // @Before("forDAOPackage()")
//   @Before("forDAOPackage()")
//    public void beforesAddAccountAdvice(){
//        System.out.println("Executing beforeadvice on addAccount()");
//    }

    @Pointcut("execution(* com.getajob.aopdemo.dao.AccountDAO.add*())")
    public void testaddAccMethod() {
    }

    @Pointcut("execution(* com.getajob.aopdemo.dao.AccountDAO.add*Account(..))")
    public void testAddAccOneParamMethod() {
    }

    @Pointcut("execution(* com.getajob.aopdemo.dao.MembershipDAO.addAccount())")
    public void testAddMemAccMethod() {
    }

    @Pointcut("execution(* com.getajob.aopdemo.dao.MembershipDAO.addS*())")
    public void testAddMemAccSillyMethod() {
    }

    //    @Pointcut("execution(* com.getajob.aopdemo.dao.AccountDAO.findAccount())")
//    public void testFindAccMethod(){
//
//    }
//    @Pointcut("execution(* com.getajob.aopdemo.dao.*.get*(. .))")
//    public void testGetter() {
//    }
//    @Pointcut("execution(* com.getajob.aopdemo.dao.*.set*(. .))")
//    public void testSetter() {
//    }
    @AfterReturning(pointcut = "execution(* com.getajob.aopdemo.dao.AccountDAO.findAccount())", returning = "result")
    public void testFindAccount(JoinPoint joinPoint, List<Account> result) {
        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("AfterReturning  " + methodSignature);
        System.out.println("AfterReturning  result " + result);
        Account a = result.get(1);
        a.setName("AfterReturning1");
        a.setLevel("1000000000");

        System.out.println("AfterReturning  after modifying the result " + result);

    }

    @AfterThrowing(pointcut = "execution(* com.getajob.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "exe")
    public void testFindThrowingAccount(JoinPoint joinPoint, Throwable exe) {
        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("AfterThrowing  " + methodSignature);
        System.out.println("AfterThrowing the exception on aspect    " + exe);
    }

    @After("execution(* com.getajob.aopdemo.dao.AccountDAO.findAccount(..))")
    public void testFindAfterAccount(JoinPoint joinPoint) {
        String methodSignature = joinPoint.getSignature().toShortString();
        System.out.println("After  " + methodSignature);
    }

    @Around("execution(* com.getajob.aopdemo.service.*.getFortune(..))")
    public Object getForturnadvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        System.out.println("In the around advice block....");
        String methodSignature = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Around advice " + methodSignature);
        long startTime = System.currentTimeMillis();
        try {

            result = proceedingJoinPoint.proceed();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
           // result = "Major accident! Your private jet is about to pick you up. Don't worry!";
            //re-throwing exception
            throw exception;
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Duration of Execution of Around Advice : " + duration / 1000.0);
        return result;

    }


}
