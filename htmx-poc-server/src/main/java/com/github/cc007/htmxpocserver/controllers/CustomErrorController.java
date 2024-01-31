package com.github.cc007.htmxpocserver.controllers;

import java.util.Optional;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

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