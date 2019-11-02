package com.itvillage.uaa.controller;


import com.itvillage.uaa.dto.request.LoginForm;
import com.itvillage.uaa.dto.request.SignUpForm;
import com.itvillage.uaa.services.SignUpAndSignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthRestAPIs {

    @Autowired
    private SignUpAndSignInService signUpAndSignInService;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        return ResponseEntity.ok(signUpAndSignInService.signIn(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        return signUpAndSignInService.signUp(signUpRequest);
    }


}