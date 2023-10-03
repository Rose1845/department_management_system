package com.rose.crud.user.service;

import com.rose.crud.error.ApiRequestHandlerException;
import com.rose.crud.user.auth.config.JwtService;
import com.rose.crud.user.email.service.EmailService;
import com.rose.crud.user.request.LoginRequest;
import com.rose.crud.user.entity.User;
import com.rose.crud.user.repository.UserRepository;
import com.rose.crud.user.request.RegistrationRequest;
import com.rose.crud.user.response.AuthenticationResponse;
import com.rose.crud.utils.GenerateOtp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final GenerateOtp generateOtp;
    private final EmailService emailService;
    private final JwtService jwtService;
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
                    .gender(registrationRequest.getGender())
                    .role(registrationRequest.getRole())
                    .otp(otp)
                    .createdAt(LocalDateTime.now())
                    .isEnabled(false)
                    .build();
            emailService.sendEmail(newUser.getEmail(),"Verify your account",newUser.getOtp());

           return userRepository.save(newUser);
//            var jwtToken=jwtService.generateToken(newUser);
//            return AuthenticationResponse.builder()
//                    .token(jwtToken)
//                    .build();


        } catch (Exception e) {
            throw new ApiRequestHandlerException("unable to send otp try again");
        }


    }

//    public String verifyAccount(String email,String otp){
//        User user = userRepository.findByEmail(email);
////                .orElseThrow( () -> new ApiRequestHandlerException(""));
//        if(user.getOtp().equals(otp) && Duration.between(user.getCreatedAt(),
//                LocalDateTime.now()).getSeconds()<(60));
//        user.setIsEnabled(true);
//        userRepository.save(user);
//        return "user verified you can now login";
//    }
public String verifyAccount(String email, String otp) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
        // Handle the case where the user with the given email is not found
        throw new IllegalStateException("User not found for email: " + email);
    }

    if (user.getOtp().equals(otp)) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime otpExpirationTime = user.getCreatedAt().plusMinutes(1); // 1 minute expiration time

        if (currentTime.isBefore(otpExpirationTime)) {
            // OTP is valid and has not expired
            user.setIsEnabled(true);
            userRepository.save(user);
            return "User verified. You can now log in.";
        } else {
            // OTP has expired
            throw new IllegalStateException("OTP has expired.");
        }
    } else {
        // Incorrect OTP
        throw new IllegalStateException("Invalid OTP.");
    }
}

    public String regenerateOtp(String email) {
        User user = userRepository.findByEmail(email);


        if(user.getOtp() != null ){
            user.setOtp(null);
        }
        String otp = generateOtp.generateOtp();
        user.setOtp(otp);
        user.setCreatedAt(LocalDateTime.now());
        emailService.sendEmail(email,"Generated OTP",otp);

        userRepository.save(user);
        return "verify your account";
    }
    public AuthenticationResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
//                .orElseThrow(()-> new ApiRequestHandlerException("user with that email exists"));
        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw  new IllegalStateException("Password incorrect");
        } else if (!user.getIsEnabled()) {
            throw new IllegalStateException("Your account is not verified");
        }
         return AuthenticationResponse.builder().build();

//        var jwtToken=jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
    }
}
