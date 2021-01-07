package com.example.session02.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CaculatorController {
    @RequestMapping("/cal")
    public String showForm()
    {
        return "calculator";
    }

    //@RequestMapping(value="/result",method = RequestMethod.GET)
    //<=> @GetMapping("")

    //@Requestmapping(value="result", method= RequestMethod.POST)
    //<=> @PostMapping("/result")
    @GetMapping(value = "/result" , params = "add")
    public String calAdd(HttpServletRequest request, ModelMap model)
    {
        double numberA = Double.parseDouble(request.getParameter("numberA"));
        double numberB = Double.parseDouble(request.getParameter("numberB"));

        double result = numberA + numberB;
        model.addAttribute("numberA",numberA);
        model.addAttribute("numberB",numberB);
        model.addAttribute("action","+");
        model.addAttribute("result",result);
        System.out.println("Result: "+result);
        return "result";
    }

    @GetMapping(value = "/result", params = "sub")
            public String calSub(HttpServletRequest request, ModelMap model)
    {
        double numberA = Double.parseDouble(request.getParameter("numberA"));
        double numberB = Double.parseDouble(request.getParameter("numberB"));
        double result = numberA - numberB;
        model.addAttribute("numberA",numberA);
        model.addAttribute("numberB",numberB);
        model.addAttribute("action","-");
        model.addAttribute("result",result);

        System.out.println("Result: "+result);
        return "result";
    }

}
