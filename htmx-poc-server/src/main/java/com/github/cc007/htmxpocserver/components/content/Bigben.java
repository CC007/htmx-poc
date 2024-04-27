package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.spring.SpringComponent;
import lombok.Getter;
import lombok.experimental.Delegate;

@SpringComponent
@Getter
public class Bigben implements Component {

    @Delegate
    private final ContentFactory.Content content;

    public Bigben(ContentFactory contentFactory) {
        content = contentFactory.create("Big Ben example", this.getClass().getSimpleName());
    }
}
