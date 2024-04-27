package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.components.Htmx;
import com.github.cc007.htmxpocserver.components.Page;
import com.github.cc007.htmxpocserver.services.HtmxService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;

@org.springframework.stereotype.Component
@RequiredArgsConstructor
public class ContentFactory {
    private final HtmxService htmxService;
    private final Htmx htmx;
    private final Page page;

    public Content create(String title, String className) {
        return new Content(htmxService, htmx, page, title, className);
    }

    @RequiredArgsConstructor
    public class Content implements Component {
        private final HtmxService htmxService;
        private final Htmx htmx;
        private final Page page;
        private final String title;
        @Getter
        private final String className;

        @Override
        public String getTemplateName(HttpServletRequest request, Model model) {
            model.addAttribute("contentTemplate", Component.super.getTemplateName(request, model));
            model.addAttribute("title", title);

            if (htmxService.isHtmxRequest(request)) {
                return htmx.getTemplateName(request, model);
            } else {
                model.addAttribute("logo", "CC007");
                return page.getTemplateName(request, model);
            }
        }
    }
}
