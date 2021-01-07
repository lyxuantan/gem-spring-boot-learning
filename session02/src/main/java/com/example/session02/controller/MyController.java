package com.example.session02.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class MyController {


    @RequestMapping("say-hello")
    public String sayHello(){
        return "hello";

    }

}
