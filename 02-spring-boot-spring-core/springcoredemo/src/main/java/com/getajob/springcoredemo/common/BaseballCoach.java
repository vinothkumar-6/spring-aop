package com.getajob.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Baseball couching workout: Hit the ball hard";
    }

    public BaseballCoach(){
        System.out.println("In BaseballCoach Constructor : "+getClass().getSimpleName());
    }
}
