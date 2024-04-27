package com.github.cc007.htmxpocserver.components;

import com.github.cc007.htmxpocserver.spring.SpringComponent;
import lombok.Getter;

@Getter
@SpringComponent
public class Page implements Component {
    private final String className = this.getClass().getSimpleName();
}
