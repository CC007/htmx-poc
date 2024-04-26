package com.github.cc007.htmxpocserver.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Slf4j
@Component
@RequiredArgsConstructor
public class TemplateResolver {;
    private final HtmxService htmxService;

    public String getTemplate(HttpServletRequest request, Model model, String templateName, String title) {
        log.info("Got request for page " + templateName);
        model.addAttribute("contentTemplate", templateName);
        model.addAttribute("title", title);

        if (htmxService.isHtmxRequest(request)) {
            return "content";
        } else {
            model.addAttribute("logo", "CC007");
            return "page";
        }
    }

}