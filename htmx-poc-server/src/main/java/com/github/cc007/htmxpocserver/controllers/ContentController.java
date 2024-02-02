package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.model.MenuItemType;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final MenuItemService menuItemService;

    @GetMapping("/bio")
    public String bio(Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.BIO));
        return "content/bio";
    }

    @GetMapping("/portfolio")
    public String portfolio(Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.PORTFOLIO));
        return "content/portfolio";
    }

    @GetMapping("/socials")
    public String socials(Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.SOCIALS));
        return "content/socials";
    }
}