package com.getajob.aopdemo;

import com.getajob.aopdemo.dao.AccountDAO;
import com.getajob.aopdemo.dao.MembershipDAO;
import com.getajob.aopdemo.entity.Account;
import com.getajob.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            System.out.println("Hello Welcome to Basic Spring Boot AOP Application ");
            //System.out.println(Account.class.getDeclaredField(getClass().getName()));
            //demoTheBeforeAdvice(accountDAO, membershipDAO);
            //demoTheAfterReturningAdvice(accountDAO);
            //	demoTheAfterThrowingAdvice(accountDAO);
            //	demoTheAroundAdvice(trafficFortuneService);
            //demoTheAroundAdviceExceptionHandling(trafficFortuneService);
            demoTheAroundAdviceExceptionReThrowing(trafficFortuneService);
        };

    }

    private void demoTheAroundAdviceExceptionReThrowing(TrafficFortuneService trafficFortuneService) {
        System.out.println("demoTheAroundAdviceExceptionReThrowing Exception Rethrowing method");
        boolean tripWire = true;
        try {
            System.out.println(trafficFortuneService.getFortune(tripWire));
        } catch (Exception exe) {
            System.out.println("Handling exception in Main app "+exe.toString());
        }
    }

    private void demoTheAroundAdviceExceptionHandling(TrafficFortuneService trafficFortuneService) {
        System.out.println("demoTheAroundAdviceExceptionHandling Exception handling method");
        boolean tripWire = true;
        System.out.println(trafficFortuneService.getFortune(tripWire));
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println(trafficFortuneService.getFortune());
    }

    public void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        accountDAO.addAccount();
        accountDAO.addAccount(new Account("Vihaan", "1"));
        membershipDAO.addAccount();
        membershipDAO.addSillyAccount();
        accountDAO.addBooleanAccount(new Account("Vinoth", "2"), true);
    }

    public void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accountList = accountDAO.findAccount();
        System.out.println("Hello demoTheAfterReturningAdvice");
    }

    public void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        try {
            boolean tripWire = false;
            List<Account> accountList = accountDAO.findAccount(tripWire);
            System.out.println("Hello demoTheAfterThrowingAdvice");
        } catch (Exception exe) {
            System.out.println("Hello demoTheAfterThrowingAdvice Exception on main app");
            System.out.println("Exception" + exe);
        }

    }
}
