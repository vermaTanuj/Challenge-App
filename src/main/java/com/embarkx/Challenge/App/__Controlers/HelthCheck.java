package com.embarkx.Challenge.App.__Controlers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelthCheck {

    @GetMapping("/check")
    public String healthCheck(){
        System.out.println("entered into check");
      return    "OK";
    }
}
