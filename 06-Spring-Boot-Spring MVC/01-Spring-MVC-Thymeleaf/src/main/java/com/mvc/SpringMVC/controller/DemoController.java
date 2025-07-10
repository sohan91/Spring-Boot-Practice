package com.mvc.SpringMVC.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model theModel)
    {
        theModel.addAttribute("theData",java.time.LocalDateTime.now());
        return "helloworld";
    }
}
