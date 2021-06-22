package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/users")
    public ModelAndView listUser(){
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("users",new User());
        return modelAndView;
    }
    @PostMapping("/validateUser")
    public ModelAndView checkUser(@Validated @ModelAttribute(name = "users") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/list","users",user);
        }
        return new ModelAndView("/result");
    }
}
