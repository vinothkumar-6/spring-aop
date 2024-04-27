package com.getajob.springboot.restapicruddemo.rest;


import com.getajob.springboot.restapicruddemo.Exception.UserNotFoundException;
import com.getajob.springboot.restapicruddemo.service.UserService;
import com.getajob.springboot.restapicruddemo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;


@RestController

@RequestMapping("/usersapi")
public class UserRestController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private UserService userService;

    public UserRestController(){}

    public UserRestController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException{

        User user = userService.getUserId(id);
        if(user == null){
            System.out.println(id);
            throw new UserNotFoundException("ID:"+id);
        }
        return user;
    }

    @GetMapping("/usersmodel/{id}")
    public EntityModel<User> getUsers(@PathVariable int id) throws UserNotFoundException{

        User user = userService.getUserId(id);
        if(user == null){
            System.out.println(id);
            throw new UserNotFoundException("ID:"+id);
        }
        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder builder = linkTo(methodOn(this.getClass()).getUserList());
        model.add(builder.withRel("all-users"));
        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

       User savedUser =  userService.createUser(user);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
         return ResponseEntity.created(location).build();
    }
    
    
    @DeleteMapping(path = "/users/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable int id){
              userService.deleteUserById(id);
    }

    @GetMapping("/users/goodmorning")
        public String getHelloMessage(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"defaultmessage",locale);

        }
    }

