package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.components.Htmx;
import com.github.cc007.htmxpocserver.components.Page;
import com.github.cc007.htmxpocserver.services.HtmxService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public abstract class ContentComponent implements Component {
    protected abstract HtmxService getHtmxService();
    protected abstract String getTitle();

    @Override
    public String getTemplateFileName(HttpServletRequest request, Model model) {
        model.addAttribute("contentTemplateFileName", Component.super.getTemplateFileName(request, model));
        model.addAttribute("title", getTitle());

        if (getHtmxService().isHtmxRequest(request)) {
            return new Htmx().getTemplateFileName(request, model);
        } else {
            model.addAttribute("logo", "CC007");
            return new Page().getTemplateFileName(request, model);
        }
    }
}
