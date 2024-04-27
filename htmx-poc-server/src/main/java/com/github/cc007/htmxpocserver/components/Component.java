package com.github.cc007.htmxpocserver.components;

import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.ui.Model;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

public interface Component {

    String EXTENSION = ".ftl";

    String getClassName();

    default String getTemplateName(HttpServletRequest request, Model model) {
        String templateFileName = getTemplateFileName();
        return templateFileName.substring(0, templateFileName.length() - EXTENSION.length());
    }

    private String getTemplateFileName() {
        URI baseUri = getBaseUri();
        String templateFileName = getClassName() + EXTENSION;
        return getResource(templateFileName)
                .map(baseUri::relativize)
                .map(URI::getPath)
                .orElse("content/error/Status500.ftl");
    }

    private URI getBaseUri() {
        return Optional.ofNullable(Component.class.getResource(""))
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
