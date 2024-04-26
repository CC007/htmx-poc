package com.github.cc007.htmxpocserver.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@RequiredArgsConstructor
public class TemplateResolver {;
    private final HtmxService htmxService;

    public String getTemplate(HttpServletRequest request, Model model, String templateName, String title) {
        model.addAttribute("contentTemplate", templateName);
        model.addAttribute("title", title);

        if (htmxService.isHtmxRequest(request)) {
            return "Htmx";
        } else {
            model.addAttribute("logo", "CC007");
            return "Page";
        }
    }

}