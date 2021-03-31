package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping(path="/demo")
    public @ResponseBody
    String getDemo(){
        return demoService.getDemo();
    }
}
