package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class CustomErrorController implements ErrorController {

    private final MenuItemService menuItemService;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("menuItems", menuItemService.getMenuItems(null));

        return Optional.ofNullable(status)
                .map(Object::toString)
                .map(Integer::parseInt)
                .map(HttpStatus::resolve)
                .map(this::getTemplate)
                .orElse("content/error");
    }

    private String getTemplate(HttpStatus httpStatus) {
        return switch (httpStatus) {
            case NOT_FOUND -> "content/error-404";
            default ->  "content/error";
        };
    }
}