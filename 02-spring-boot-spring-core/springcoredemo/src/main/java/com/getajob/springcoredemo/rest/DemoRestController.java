package com.getajob.springcoredemo.rest;

import com.getajob.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    //creating a private field for the dependancy
    private Coach myCouch;

    //private Coach anotherCouch;

  //  defining constructor for dependancy injection used for required dependencies
//    @Autowired
//    public DemoRestController(@Qualifier("swimCouch") Coach theCoach
//                             // ,@Qualifier("cricketCoach") Coach theAnotherCouch\
//                              ){
//        myCouch = theCoach;
//       // anotherCouch =  theAnotherCouch;
//
//    }

    @Autowired
    public DemoRestController(@Qualifier("aquatic") Coach theCoach){
        myCouch = theCoach;
    }

    //dependency injection using setter methods used for optional dependencies
//    @Autowired
//    public void setCouch(Coach myCouch) {
//        this.myCouch = myCouch;
//    }

    //instead of using setter method, and constructor we are going to do some dummy methods with autowired
//    @Autowired
//    public void setOurCoach(Coach yourCouch){
//        this.myCouch = yourCouch;
//    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkOut() {
        return myCouch.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check(){
       //return "Comparing beans : (anotherCouch and myCouch)"+ (myCouch == anotherCouch);
        return null;
    }


}
