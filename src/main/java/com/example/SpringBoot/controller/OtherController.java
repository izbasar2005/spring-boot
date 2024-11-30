package com.example.SpringBoot.controller;


import com.example.SpringBoot.beans.TestA;
import com.example.SpringBoot.beans.TestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private TestA testA;

    @Autowired
    private TestB testB;
    @GetMapping(value = "/test-a")
    public String testA(Model model) {

        System.out.println(testA.getName());
        model.addAttribute("testA", testA);

        System.out.println(testB.getCode()+" "+testB.getVolume());
        return "test";
    }
}
