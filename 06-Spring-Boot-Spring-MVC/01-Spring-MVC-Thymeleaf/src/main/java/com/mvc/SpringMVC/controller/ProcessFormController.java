package com.mvc.SpringMVC.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProcessFormController {

    @GetMapping("/form")
    public String process()
    {
        return "hello-world-form";
    }

    @RequestMapping("/processedForm")
    public String hello()
    {
        return "hello-world-process";
    }

    @PostMapping("/checkModel")
    public String check(@RequestParam("studentName") String name, Model model)
    {

        String theName = name.toUpperCase();

        String updatedName = "Hey, "+theName;

        model.addAttribute("message",updatedName);

        return "check-model";
    }
}
