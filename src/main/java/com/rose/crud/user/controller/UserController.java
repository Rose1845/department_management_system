package com.rose.crud.user.controller;

import com.rose.crud.user.entity.User;
import com.rose.crud.user.request.LoginRequest;
import com.rose.crud.user.request.RegistrationRequest;
import com.rose.crud.user.response.AuthenticationResponse;
import com.rose.crud.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest registerRequest) throws Exception {
        return userService.register(registerRequest);

    }
    @PutMapping("/verify-account")
    public ResponseEntity<String> verifyAccount(@RequestParam String email, @RequestParam String otp){
        return new ResponseEntity<>(userService.verifyAccount(email,otp), HttpStatus.OK);
    }
    @PutMapping("/regenerate-otp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email){
        return new ResponseEntity<>(userService.regenerateOtp(email), HttpStatus.ACCEPTED);
    }
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

}
