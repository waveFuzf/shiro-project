package com.example.shiroproject.service;

import org.springframework.stereotype.Service;

@Service
public class ShiroService {

    public String getPasswordByUsername(String username){
        switch (username){
//            fuzf0206
            case "fuzf":
                return "2ae318ce6c8dd1995a815f2bd228cd9f";
//            mady0115
            case "mady":
                return "f466d242a5c6502e510c06cab14d2955";
            default:
                return null;
        }
    }
}