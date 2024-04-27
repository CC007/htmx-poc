package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.spring.SpringComponent;
import lombok.Getter;
import lombok.experimental.Delegate;

@SpringComponent
@Getter
public class Portfolio implements Component {

    @Delegate
    private final ContentFactory.Content content;

    public Portfolio(ContentFactory contentFactory) {
        content = contentFactory.create("Portfolio", this.getClass().getSimpleName());
    }
}
