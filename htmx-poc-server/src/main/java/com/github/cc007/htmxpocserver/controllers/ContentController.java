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

    private final MenuItemService menuItemService;
    private final Bio bio;
    private final Portfolio portfolio;
    private final Socials socials;

    @GetMapping("/bio")
    public String bio(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.BIO));
        return bio.getTemplateName(request, model);
    }

    @GetMapping("/portfolio")
    public String portfolio(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.PORTFOLIO));
        return portfolio.getTemplateName(request, model);
    }

    @GetMapping("/socials")
    public String socials(HttpServletRequest request, Model model) {
        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.SOCIALS));
        return socials.getTemplateName(request, model);
    }

    @GetMapping("/trigger-error")
    public String triggerError(HttpServletRequest request, Model model) {
        class ThisIsFine extends RuntimeException {
            public ThisIsFine(String message) {
                super(message);
            }
        }
        throw new ThisIsFine("Test the error page");
    }
}