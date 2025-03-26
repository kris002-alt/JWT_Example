package com.jwt.example.basicauth.config;

import com.jwt.example.basicauth.models.JwtRequest;
import com.jwt.example.basicauth.models.JwtResponse;
import com.jwt.example.basicauth.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtHelper jwtHelper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);
@PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());


    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
    String token =this.jwtHelper. generateToken(userDetails);

    JwtResponse jwtResponse = JwtResponse.builder().jwtToken(token).username(userDetails.getUsername()).build();
    return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
}

    private void doAuthenticate(String email, String password) {
    UsernamePasswordAuthenticationToken  authenticationToken= new UsernamePasswordAuthenticationToken(email, password);
    try {
authenticationManager.authenticate(authenticationToken);
    }catch (BadCredentialsException e){
        throw new BadCredentialsException("Invalid email or password");
    }
    }


}
