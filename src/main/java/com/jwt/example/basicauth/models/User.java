package com.jwt.example.basicauth.models;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String userId;
    private String userName;
    private  String userEmail;
}
