package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.components.Page;
import com.github.cc007.htmxpocserver.components.content.Home;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MenuItemService menuItemService;
    private final Home home;
    private final Page page;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(null));
        return "page";//page.getTemplateName(request, model);
    }

}