package com.example.shiroproject.service;

import org.springframework.stereotype.Service;

@Service
public class ShiroService {

    public String getPasswordByUsername(String username){
        switch (username){
            case "fuzf":
                return "1e89ed6a09bf3cdffcb8f7e8292bc067";
            case "mady":
                return "33f574409907dd37e31e7c9467b42fc2";
            default:
                return null;
        }
    }
}