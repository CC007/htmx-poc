package com.github.cc007.htmxpocserver.components;

import lombok.Getter;

@Getter
public class DummyComponentWithoutTemplate implements Component {
    private final String className = this.getClass().getSimpleName();
}
