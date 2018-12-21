package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.model.PhoneNumber;

import javax.validation.Valid;

@Controller
public class EmailController {
    @GetMapping("/email")
    public String showForm(Model model){
        model.addAttribute("email", new Email());
        return "email";
    }

    @PostMapping("/valid-email")
    public String checkValidation (@Valid @ModelAttribute("email")Email email, BindingResult bindingResult, Model model){
        new Email().validate(email, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "email";
        }
        else {
            model.addAttribute("email",email.getEmail());
            return "resultemail";
        }
    }
}