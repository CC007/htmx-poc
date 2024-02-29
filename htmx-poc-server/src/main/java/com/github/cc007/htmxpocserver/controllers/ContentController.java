package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.model.MenuItemType;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import com.github.cc007.htmxpocserver.services.TemplateResolver;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final MenuItemService menuItemService;
    private final TemplateResolver templateResolver;

    @GetMapping("/bio")
    public String bio(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.BIO));
        return templateResolver.getTemplate(request, model, "bio");
    }

    @GetMapping("/portfolio")
    public String portfolio(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.PORTFOLIO));
        return templateResolver.getTemplate(request, model, "portfolio");
    }

    @GetMapping("/socials")
    public String socials(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.SOCIALS));
        return templateResolver.getTemplate(request, model, "socials");
    }
}