package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.components.content.error.ErrorFactory;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import com.github.cc007.htmxpocserver.services.TemplateResolver;
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
    private final TemplateResolver templateResolver;
    private final ErrorFactory errorFactory;

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

        return errorFactory.create(httpStatus).getTemplateName(request, model);
    }
}