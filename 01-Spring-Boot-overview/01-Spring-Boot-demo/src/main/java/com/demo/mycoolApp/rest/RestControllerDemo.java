package com.demo.mycoolApp.rest;

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
    }

