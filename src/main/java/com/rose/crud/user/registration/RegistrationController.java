package com.rose.crud.user.registration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class RegistrationController {
    @Autowired
    private final RegistrationService registrationService;

   public String registerUser(@RequestBody RegistrationRequest registrationRequest){
     return  registrationService.registerUser(registrationRequest);
   }


}
