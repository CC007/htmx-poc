package com.github.cc007.htmxpocserver.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@RequiredArgsConstructor
public class TemplateResolver {;
    private final HtmxService htmxService;

    public String getTemplate(HttpServletRequest request, Model model, String templateName) {
        if (htmxService.isHtmxRequest(request)) {
            return "content/" + templateName;
        } else {
            model.addAttribute("contentTemplate", "components/" + templateName);
            model.addAttribute("logo", "CC007");
            model.addAttribute("tosUrl", "/tos");
            model.addAttribute("contactUrl", "/contact");
            return "index";
        }
    }

}