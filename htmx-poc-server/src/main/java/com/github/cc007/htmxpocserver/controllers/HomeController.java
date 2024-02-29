package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.services.MenuItemService;
import com.github.cc007.htmxpocserver.services.TemplateResolver;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MenuItemService menuItemService;
    private final TemplateResolver templateResolver;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(null));
        return templateResolver.getTemplate(request, model, "home", "Homepage");
    }

}