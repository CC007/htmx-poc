package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.components.content.Bio;
import com.github.cc007.htmxpocserver.components.content.Portfolio;
import com.github.cc007.htmxpocserver.components.content.Socials;
import com.github.cc007.htmxpocserver.model.MenuItemType;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
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
    public String bio(HttpServletRequest request, Model model) {
        model.addAttribute(MENU_ITEMS_KEY, menuItemService.getMenuItems(MenuItemType.BIO));
        return bio.getTemplateName(request, model);
    }

    @GetMapping("/portfolio")
    public String portfolio(HttpServletRequest request, Model model) {
        model.addAttribute(MENU_ITEMS_KEY, menuItemService.getMenuItems(MenuItemType.PORTFOLIO));
        return portfolio.getTemplateName(request, model);
    }

    @GetMapping("/socials")
    public String socials(HttpServletRequest request, Model model) {
        model.addAttribute(MENU_ITEMS_KEY, menuItemService.getMenuItems(MenuItemType.SOCIALS));
        return socials.getTemplateName(request, model);
    }

    @GetMapping("/trigger-error")
    public String triggerError() {
        class ThisIsFine extends RuntimeException {
            public ThisIsFine(String message) {
                super(message);
            }
        }
        throw new ThisIsFine("Test the error page");
    }
}