package com.github.cc007.htmxpocserver.components;

import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.ui.Model;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

public interface Component {

    default String getTemplateName() {
        String templateFileName = getTemplateFileName(null, null);
        return templateFileName.substring(0, templateFileName.length() - 4);
    }

    default String getTemplateFileName(HttpServletRequest request, Model model) {
        URI baseUri = getBaseUri();
        String templateFileName = this.getClass().getSimpleName() + ".ftl";
        return getResource(templateFileName)
                .map(baseUri::relativize)
                .map(URI::getPath)
                .orElse("error/Status500.ftl");
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
