package com.vedant.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerDemo {
    //create a mapping for hello
    @GetMapping("/hello")
    public String getHello(Model theModel){
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld-form";
    }

}
