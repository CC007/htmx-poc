package com.github.cc007.htmxpocserver.components;

import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.ui.Model;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

public interface Component {
    Logger log = org.slf4j.LoggerFactory.getLogger(Component.class);

    String COMPONENT_TEMPLATE_PREFIX = "/com/github/cc007/htmxpocserver/components";

    default String getTemplateName(HttpServletRequest request, Model model) {
        String templateFileName = getTemplateFileName(request, model);
        return templateFileName.substring("/".length(), templateFileName.length() - ".ftl".length());
    }

    default String getTemplateFileName(HttpServletRequest request, Model model) {
        URI baseUri = getBaseUri();
        String templateFileName = this.getClass().getSimpleName() + ".ftl";
        String canonicalFileName = getResource(templateFileName)
                .map(baseUri::relativize)
                .map(URI::getPath)
                .orElse(COMPONENT_TEMPLATE_PREFIX + "content/error/Status500.ftl");
        log.info("Template name: /$canonicalFileName");
        return "/$canonicalFileName";
    }

    private URI getBaseUri() {
        return Optional.ofNullable(getClass().getClassLoader().getResource(""))
                .map(Component::getUri)
                .orElseThrow();
    }

    private Optional<URI> getResource(String templateFileName) {
        return Optional.ofNullable(getClass().getResource(templateFileName))
                .map(Component::getUri);
    }

    @SneakyThrows(URISyntaxException.class)
    private static URI getUri(URL url) {
        return url.toURI();
    }
}
