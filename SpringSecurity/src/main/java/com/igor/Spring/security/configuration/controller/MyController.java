package com.igor.Spring.security.configuration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String getInfoForAllEmp() {
        return "view for all employees";
    }
    @GetMapping("/HR_info")
    public String getInfoOnlyForHr() {
        return "view for all HR";
    }
    @GetMapping("/IT_info")
    public String getInfoOnlyForIt() {
        return "view for all IT";
    }
}
