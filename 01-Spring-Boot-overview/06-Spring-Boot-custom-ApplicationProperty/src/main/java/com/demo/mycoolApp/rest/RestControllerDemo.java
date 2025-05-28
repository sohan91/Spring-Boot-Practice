package com.demo.mycoolApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
        @GetMapping("/")
                public String toString()
        {
            return "Hello World";
        }
        @GetMapping("/workOut")
               public String getWorkOut()
        {
            return "It's working on Workout!!";
        }
        @GetMapping("/fortune")
        public String fortune()
        {
            return "Today is Memorable Dayy!!";
        }

    }

