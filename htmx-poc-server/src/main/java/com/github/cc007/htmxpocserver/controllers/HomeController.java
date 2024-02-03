package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.services.HtmxService;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MenuItemService menuItemService;
    private final HtmxService htmxService;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(null));

        if (htmxService.isHtmxRequest(request)) {
            return "content/home";
        } else {
            model.addAttribute("logo", "CC007");
            model.addAttribute("tosUrl", "/tos");
            model.addAttribute("contactUrl", "/contact");
            return "index";
        }
    }
}