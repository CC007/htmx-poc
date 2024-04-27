package com.github.cc007.htmxpocserver.components;

import lombok.Getter;

@Getter
public class DummyComponent implements Component {
    private final String className = this.getClass().getSimpleName();
}
