package com.thyemelefsecurity.Thymeleaf_Security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {

    @GetMapping("/home")
    public String home()
    {
        return "home";
    }
    @GetMapping("/showLoginPage")
    public String form()
    {
          return "login-form";
    }
//    @PostMapping("/authenticateUser")
//    public String authenticate()
//    {
//        return "authenticate-user";
//    }
}
