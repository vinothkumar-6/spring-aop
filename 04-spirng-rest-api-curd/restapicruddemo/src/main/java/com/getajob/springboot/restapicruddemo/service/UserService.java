package com.getajob.springboot.restapicruddemo.service;

import com.getajob.springboot.restapicruddemo.entity.user.User;

import java.util.List;


    public interface UserService {
        public List<User> getUserList();

        public User getUserId(int id);

        public User createUser(User user);

        public void deleteUserById(int id);
    }


