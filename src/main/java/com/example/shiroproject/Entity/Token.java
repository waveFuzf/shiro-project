package com.example.shiroproject.Entity;

import lombok.Data;

@Data
public class Token {
    private String username;
    private String token;

    public Token(String username, String tokenId) {
        this.username=username;
        this.token=tokenId;
    }
}
