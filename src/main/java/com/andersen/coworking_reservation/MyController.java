package com.andersen.coworking_reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/index")
    public String askLoginOrRegister(){
        return "ask-login-register-view";
    }

    @RequestMapping("/show-login-details")
    public String showLoginDetails(){
        return "login-details-view";
    }

    @RequestMapping("/show-register-details")
    public String showRegisterDetails(){
        return "register-details-view";
    }
}