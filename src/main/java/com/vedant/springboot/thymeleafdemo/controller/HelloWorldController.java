package com.vedant.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm" )
    public String processForm(){
        return "helloworld";
    }

    //need a controller to read form data
    //add data to the model
    @RequestMapping("/processFormVersion2" )
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read request parameter from HTML form
        String name = request.getParameter("studentName");
        //convert the data to all caps
        String theName = name.toUpperCase();

        //create the message
        String result = "YO! " + theName;

        //add message to model

        model.addAttribute("message", result);
        return "helloworld";
    }

    @GetMapping("/processFormVersion3" )
    public String processForm3(@RequestParam("studentName") String theName, Model model){
        //read request parameter from HTML form
        //convert the data to all caps

        //create the message
        String result = "Homie! " + theName;

        //add message to model

        model.addAttribute("message", result);
        return "helloworld";
    }
}
