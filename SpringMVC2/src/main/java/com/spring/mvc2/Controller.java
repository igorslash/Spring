package com.spring.mvc2;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller

@RequestMapping("/employee")
public class Controller {
    @RequestMapping("/")
    public String showFirstView() {
        return "first view";
    }

    // @RequestMapping("/askDetails")
    // public String askEmployeeDetails() {
    // return "ask emp details view";
    // }
    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask emp details view";
    }


//    @RequestMapping("/showDetails")
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
//        empName = "Mr" + empName;
//        model.addAttribute("nameAttribute", empName);
//     return "show emp details view";
//}
    @RequestMapping("/showDetails")
   public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult result) {
        //Valid проверка на ошибки
        if (result.hasErrors()) {
            return "ask emp details view";
        }
        return "show emp details view";
    }
}



