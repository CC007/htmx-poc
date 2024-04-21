package com.github.cc007.htmxpocserver.components;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import lombok.SneakyThrows;
import org.springframework.ui.Model;

public interface Component {

    String COMPONENT_TEMPLATE_PREFIX = "com/github/cc007/htmxpocserver/components";

    default String getTemplateName(HttpServletRequest request, Model model) {
        String templateFileName = getTemplateFileName(null, null);
        return templateFileName.substring(0, templateFileName.length() - 4);
    }

    default String getTemplateFileName(HttpServletRequest request, Model model) {
        URI baseUri = getBaseUri();
        String templateFileName = this.getClass().getSimpleName() + ".ftl";
        return getResource(templateFileName)
                .map(baseUri::relativize)
                .map(URI::getPath)
                .orElse(COMPONENT_TEMPLATE_PREFIX + "/error/500.ftl");
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
