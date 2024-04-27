package com.getajob.springboot.restapicruddemo.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2, message = "Username should be minimum 2 in length")
    @JsonProperty("user_name")
    private String userName;

    @Past(message = "birthDate should be past")
    private LocalDate birthDate;

    public User(int id, String userName, LocalDate birthDate) {
        this.id = id;
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
