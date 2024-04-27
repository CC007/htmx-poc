package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.Component;
import lombok.Getter;

@Getter
public class DummyContentComponent implements Component {
    private final String className = this.getClass().getSimpleName();
}
