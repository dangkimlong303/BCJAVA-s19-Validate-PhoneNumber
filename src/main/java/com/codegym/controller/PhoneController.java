package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "phone";
    }
    @PostMapping("/valid-phone")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "phone";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber.getNumber());
            return "result";
        }
    }
}