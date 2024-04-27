package com.getajob.springcoredemo.common;

import org.springframework.web.bind.annotation.GetMapping;

public class SwimCoach implements Coach{


    public SwimCoach(){
        System.out.println("In Swim couch constructor");
    }


    @Override
    public String getDailyWorkOut() {
        return "Swim continuously for 5 days or die lol";
    }
}
