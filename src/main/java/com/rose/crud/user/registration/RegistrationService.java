package com.rose.crud.user.registration;

import com.rose.crud.user.entity.User;
import com.rose.crud.user.enums.UserRole;
import com.rose.crud.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;


    public String registerUser(RegistrationRequest registrationRequest) {
        boolean isEmailValid = emailValidator.test(registrationRequest.getEmail());
        if(!isEmailValid){
            throw new IllegalStateException("email not valid");
        }

        return userService.signUpUser(new User(
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getFirstName(),
                registrationRequest.getPassword(),
                UserRole.USER
        ));
    }
}
