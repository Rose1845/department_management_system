package com.rose.crud.user.service;

import com.rose.crud.error.ApiRequestHandlerException;
import com.rose.crud.user.request.LoginRequest;
import com.rose.crud.user.entity.User;
import com.rose.crud.user.repository.UserRepository;
import com.rose.crud.user.request.RegistrationRequest;
import com.rose.crud.utils.GenerateOtp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final GenerateOtp generateOtp;
//    private final EmailUtil emailUtil;
    public User register(RegistrationRequest registrationRequest) throws Exception {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(registrationRequest.getEmail()));
        if (existingUser.isPresent()) {
            // User is already registered, handle accordingly (e.g., return an error, throw an exception)
            throw new ApiRequestHandlerException("User is already registered");
        }

        String otp = generateOtp.generateOtp();
        try {
            User newUser = User.builder()
                    .email(registrationRequest.getEmail())
                    .firstName(registrationRequest.getFirstName())
                    .lastName(registrationRequest.getLastName())
                    .password(registrationRequest.getPassword())
                    .otp(otp)
                    .createdAt(LocalDateTime.now())
                    .isEnabled(false)
                    .build();
//            emailUtil.sendOtpEmail(registerRequest.getEmail(),otp);

            return userRepository.save(newUser);

        } catch (Exception e) {
            throw new ApiRequestHandlerException("unable to send otp try again");
        }


    }

    public String verifyAccount(String email,String otp){
        User user = userRepository.findByEmail(email);
//                .orElseThrow( () -> new ApiRequestHandlerException(""));
        if(user.getOtp().equals(otp) && Duration.between(user.getCreatedAt(),
                LocalDateTime.now()).getSeconds()<(60));
        user.setIsEnabled(true);
        userRepository.save(user);
        return "user verified you can now login";

    }
    public String regenerateOtp(String email) {
        User user = userRepository.findByEmail(email);
//                .orElseThrow(() -> new RuntimeException("User not found"));
//                .orElseThrow(() -> new ApiRequestHandlerException("User not found"));

        if(user.getOtp() != null ){
            user.setOtp(null);
        }
        String otp = generateOtp.generateOtp();
        user.setOtp(otp);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return "verify your account";
    }
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
//                .orElseThrow(()-> new ApiRequestHandlerException("user with that email exists"));
        if(!user.getPassword().equals(loginRequest.getPassword())){
            return "Password Incorrect";
        } else if (!user.getIsEnabled()) {
            return "Your account is not verified";
        }
        return "Logged in sucessfully";
    }
}
