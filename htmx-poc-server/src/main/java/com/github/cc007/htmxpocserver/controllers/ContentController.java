package com.github.cc007.htmxpocserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/bio")
    public String bio() {
        return "content/bio";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "content/portfolio";
    }

    @GetMapping("/socials")
    public String socials() {
        return "content/socials";
    }
}