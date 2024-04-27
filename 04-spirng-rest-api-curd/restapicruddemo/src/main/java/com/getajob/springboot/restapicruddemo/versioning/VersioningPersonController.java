package com.getajob.springboot.restapicruddemo.versioning;

import com.getajob.springboot.restapicruddemo.entity.person.Person;
import com.getajob.springboot.restapicruddemo.entity.person.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class VersioningPersonController {

    @GetMapping("/v1/persons")
    public Person getFirstVersionOfPerson(){
       return new Person("Vinoth Kumar");
    }

    @GetMapping("/v2/persons")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2("Vinoth","Kumar");
    }

    @GetMapping(path = "/person", params ="version=1")
    public Person getFirstVersionOfPersonRequestParameter(){
        return new Person("VinothKumar");
    }

    @GetMapping(path = "/person", params ="version=2")
    public PersonV2 getSecondVersionOfPersonV2RequestParameter(){
        return new PersonV2("Vinoth","Kumar");
    }

    @GetMapping(path = "/person/header", headers ="X-API-VERSION=1")
    public Person getFirstVersionOfPersonRequestHeader(){
        return new Person("VinothKumar");
    }

    @GetMapping(path = "/person/header", headers ="X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonV2RequestHeader(){
        return new PersonV2("Vinoth","Kumar");
    }

    @GetMapping(path = "/person/accept", produces ="application/vnd.company.app-v1+json")
    public Person getFirstVersionOfPersonAcceptHeader(){
        return new Person("VinothKumar");
    }


}
