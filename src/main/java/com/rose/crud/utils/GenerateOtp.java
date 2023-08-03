package com.rose.crud.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateOtp {
    public String generateOtp(){
        Random random = new Random();
        int randomNUmber = random.nextInt(999999);
        String output = Integer.toString(randomNUmber);
        while (output.length() < 6){
            output = "0" + output;
        }
        return output;
    }
}
