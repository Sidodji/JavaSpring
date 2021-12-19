package com.example.project.entity.model;

import lombok.Data;

@Data
public class Token {
    private String token;

    public Token() { }

    public Token(String token) {
        this.token = token;
    }
}
