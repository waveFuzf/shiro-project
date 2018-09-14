package com.example.shiroproject.service;

import org.springframework.stereotype.Service;

@Service
public class ShiroService {

    public String getPasswordByUsername(String username){
        switch (username){
            case "fuzf":
                return "40b64582a14c046edee44a5d85837326";
            case "mady":
                return "8c675549aac210af3536eaf60b1da737";
            default:
                return null;
        }
    }
}