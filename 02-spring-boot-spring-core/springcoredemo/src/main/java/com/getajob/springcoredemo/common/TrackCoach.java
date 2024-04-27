package com.getajob.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Track Couch WorkOuts: track the calories";
    }

    public TrackCoach(){
        System.out.println("In TrackCoach Constructor : "+getClass().getSimpleName());
    }
}
