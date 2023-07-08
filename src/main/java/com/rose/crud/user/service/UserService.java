package com.rose.crud.user.service;

import com.rose.crud.user.entity.User;
import com.rose.crud.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService  implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private  final static String  USER_WITH_EMAIL_NOT_FOUND = "user with email not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       return userRepository.findByEmail(email).orElseThrow(()->
              new  UsernameNotFoundException(String.format(USER_WITH_EMAIL_NOT_FOUND,email)));

    }

    public String signUpUser(User user){
      boolean userExists =  userRepository.findByEmail(user.getEmail())
                .isPresent();
      if(userExists){
          throw new IllegalStateException("Email already exists");
      }
      String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);

      userRepository.save(user);

      return "Registration Successfully!!";


    }

}
