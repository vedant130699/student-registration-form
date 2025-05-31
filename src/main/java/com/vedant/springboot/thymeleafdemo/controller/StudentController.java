package com.vedant.springboot.thymeleafdemo.controller;

import com.vedant.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> Countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingsystems}")
    private List<String> operating_systems;
    @RequestMapping("/showStudentForm")
    public String showForm(Model theModel){
        //create a new student object

        Student theStudent = new Student();

        //add that object as a model attribute
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", Countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("operatingsystems", operating_systems);


        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        //logging

        System.out.println("theStudent: "+ theStudent.getFirstName() +" "+ theStudent.getLastName());
        return "student-confirmation";
    }

}
