package com.github.cc007.htmxpocserver.components.content.error;

import com.github.cc007.htmxpocserver.components.Component;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@org.springframework.stereotype.Component
@RequiredArgsConstructor
public class ErrorFactory {
    private final Status404 status404;
    private final Status500 status500;

    public Component create(HttpStatus status) {
        return getComponentFromStatus(status);
    }

    private Component getComponentFromStatus(HttpStatus status) {
        return switch (status) {
            case NOT_FOUND -> status404;
            default -> status500;
        };
    }

}
