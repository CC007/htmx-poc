package com.github.cc007.htmxpocserver.controllers;

import java.util.Arrays;
import java.util.List;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("logo", "CC007");
        model.addAttribute("content", "Lorum ipsum dolor...");

        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("Bio", "/bio"),
                new MenuItem("Portfolio", "/portfolio"),
                new MenuItem("Socials", "/socials")
        );
        model.addAttribute("menuItems", menuItems);

        model.addAttribute("tosUrl", "/tos");
        model.addAttribute("contactUrl", "/contact");

        return "index";
    }

    @Value
    public static class MenuItem {
        String name;
        String url;
    }
}