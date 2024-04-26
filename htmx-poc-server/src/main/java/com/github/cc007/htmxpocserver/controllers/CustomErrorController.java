package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.components.content.error.Status404;
import com.github.cc007.htmxpocserver.components.content.error.Status500;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CustomErrorController implements ErrorController {

    private final MenuItemService menuItemService;
    private final Status404 status404;
    private final Status500 status500;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("menuItems", menuItemService.getMenuItems(null));

        HttpStatus httpStatus = Optional
                .ofNullable(status)
                .map(Object::toString)
                .map(Integer::parseInt)
                .map(HttpStatus::resolve)
                .orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        return getContentTemplate(httpStatus, request, model);
    }

    private String getContentTemplate(HttpStatus httpStatus, HttpServletRequest request, Model model) {
        return switch (httpStatus) {
            case NOT_FOUND -> status404.getTemplateName(request, model);
            default -> status500.getTemplateName(request, model);
        };
    }
}