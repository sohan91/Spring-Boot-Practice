package com.spring.mvc.thyemeleaf.Spring_Thymeleaf.rest;

import com.spring.mvc.thyemeleaf.Spring_Thymeleaf.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {


    @InitBinder
    public void register(WebDataBinder binder)
    {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,trimmerEditor);
    }

    @GetMapping("/form")
    public String form(Model model)
    {
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }

    @PostMapping("/confirmForm")
    public String confirm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult result)
    {
        if(result.hasErrors()) {
            return "customer-form";
        }
        return "submit-form";
    }
}
