package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.components.content.Bio;
import com.github.cc007.htmxpocserver.components.content.Portfolio;
import com.github.cc007.htmxpocserver.components.content.Socials;
import com.github.cc007.htmxpocserver.model.MenuItemType;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ContentController {

    public static final String MENU_ITEMS_KEY = "menuItems";

    private final MenuItemService menuItemService;
    private final Bio bio;
    private final Portfolio portfolio;
    private final Socials socials;

    @GetMapping("/bio")
    public String bio(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setHeader("Cache-Control", "max-age=60, stale-while-revalidate=600");
        response.setHeader("Vary", "HX-Request");
        model.addAttribute(MENU_ITEMS_KEY, menuItemService.getMenuItems(MenuItemType.BIO));
        return bio.getTemplateName(request, model);
    }

    @GetMapping("/portfolio")
    public String portfolio(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setHeader("Cache-Control", "max-age=60, stale-while-revalidate=600");
        response.setHeader("Vary", "HX-Request");
        model.addAttribute(MENU_ITEMS_KEY, menuItemService.getMenuItems(MenuItemType.PORTFOLIO));
        return portfolio.getTemplateName(request, model);
    }

    @GetMapping("/socials")
    public String socials(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setHeader("Cache-Control", "max-age=60, stale-while-revalidate=600");
        response.setHeader("Vary", "HX-Request");
        model.addAttribute(MENU_ITEMS_KEY, menuItemService.getMenuItems(MenuItemType.SOCIALS));
        return socials.getTemplateName(request, model);
    }

    @GetMapping("/trigger-error")
    public String triggerError(HttpServletResponse response) {
        response.setHeader("Cache-Control", "max-age=60, stale-while-revalidate=600");
        response.setHeader("Vary", "HX-Request");
        class ThisIsFine extends RuntimeException {
            public ThisIsFine(String message) {
                super(message);
            }
        }
        throw new ThisIsFine("Test the error page");
    }
}