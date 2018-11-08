package com.example.shiroproject.Entity;

import lombok.Data;
import javax.persistence.Id;

import java.util.List;

@Data
public class User {
    @Id
    private Integer id;

    private String name;

    private String birthday;

    private String city;

    private List<Grade> g;


    public User(String s, String s1, String s2) {
        this.name=s;
        this.city=s1;
        this.birthday=s2;

    }

    public User() {
    }
}