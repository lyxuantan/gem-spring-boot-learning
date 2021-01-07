package com.example.session02.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {



    @RequestMapping("/student/form")

    @Primary

    public String showForm()
    {
        return "student-form";
    }
    @RequestMapping("/student/save")
    public String saveDate(HttpServletRequest request, ModelMap model)
    {
        String name = request.getParameter("name");
        String mark = request.getParameter("mark");
        String major = request.getParameter("major");
        model.addAttribute("NAME",name);
        model.addAttribute("MARK",mark);
        model.addAttribute("MAJOR",major);

        return "student-infor";
    }
}
