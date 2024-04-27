package com.getajob.springboot.demo.getajobapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World SpringBoot Learning Start!";
    }

    @Value("$coach.name")
    private String coachName;

    @Value("$team.name")
    private String teamName;

}
