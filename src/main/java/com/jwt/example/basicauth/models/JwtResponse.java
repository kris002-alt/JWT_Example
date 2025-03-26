package com.jwt.example.basicauth.models;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    private String jwtToken;
    private String username;
}
