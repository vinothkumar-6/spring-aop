package com.getajob.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Hit the tennis ball so hard";
    }

    public TennisCoach(){
        System.out.println("In TennisCouch Constructor : "+getClass().getSimpleName());
    }
}
