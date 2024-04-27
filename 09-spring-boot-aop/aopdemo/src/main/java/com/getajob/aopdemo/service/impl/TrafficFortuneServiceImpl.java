package com.getajob.aopdemo.service.impl;

import com.getajob.aopdemo.service.TrafficFortuneService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception exe) {
            System.out.println("exception" + exe);
        } finally {
            System.out.println("Hello Finally");
        }
        return "Except traffic delay this morning";
    }

    @Override
    public String getFortune(boolean value) {

        if(value){
            throw new RuntimeException("Major Accident! take another route");
        }
        return getFortune();
    }
}
