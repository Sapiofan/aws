package com.sapiofan.aws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanStalkController {
    @GetMapping("/result")
    public String deploy() {
        return "Successfully deployed on BeanStalk";
    }
}
