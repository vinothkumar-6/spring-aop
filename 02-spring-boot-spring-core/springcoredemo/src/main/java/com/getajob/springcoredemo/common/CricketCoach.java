package com.getajob.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

//    @PostConstruct
//    public void init(){
//        System.out.println("Initializing stuff during initialization In cricket couch Init method");
//    }

    @Override
    public String getDailyWorkOut() {
        return "Practise more on batting, fielding and Bowling..... Do you understand.... O......k....Good!!!!!!!";
    }

    public CricketCoach() {
        System.out.println("In CricketCoach Constructor : " + getClass().getSimpleName());
    }

//    @PreDestroy
//    public void destroy(){
//        System.out.println("Destroying the bean configurations using PreDestroy method");
//    }
}
