package com.getajob.springboot.restapicruddemo.service.impl;


import com.getajob.springboot.restapicruddemo.service.UserService;
import com.getajob.springboot.restapicruddemo.entity.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserServiceImpl  implements UserService {
     static  List<User> userList;
    static {
        userList = new ArrayList<>(Arrays.asList(new User(1, "Vinoth", LocalDate.now().minusYears(30)), new User(2, "Kumar", LocalDate.now().minusYears(20)), new User(3, "Rithu", LocalDate.now().minusYears(10))));

    }
    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User getUserId(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public User createUser(User user) {
        System.out.println(user.toString());
        userList.add(user);
        return user;

    }

    @Override
    public void deleteUserById(int id) {
//        System.out.println(id);
//Predicate<? super User > predicate = user -> user.getId() == id;
// System.out.println(predicate.toString());

        for (User user: userList){
            if(user.getId()==id){
                System.out.println(userList.toString());
                userList.remove(user);
            }
        }
    }
}
