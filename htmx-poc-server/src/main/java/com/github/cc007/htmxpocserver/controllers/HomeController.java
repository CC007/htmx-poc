package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.services.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MenuItemService menuItemService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("logo", "CC007");
        model.addAttribute("content", "Lorum ipsum dolor...");
        model.addAttribute("menuItems", menuItemService.getMenuItems(null));

        model.addAttribute("tosUrl", "/tos");
        model.addAttribute("contactUrl", "/contact");

        return "index";
    }

}