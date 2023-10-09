package com.sapiofan.aws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ec2Controller {

    @GetMapping("/aws")
    public String home() {
        return "The first AWS deployment was successful";
    }
}