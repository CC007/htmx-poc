package com.github.cc007.htmxpocserver.components.content.error;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.components.content.ContentFactory;
import com.github.cc007.htmxpocserver.spring.SpringComponent;
import lombok.Getter;
import lombok.experimental.Delegate;

@SpringComponent
@Getter
public class Status404 implements Component {

    @Delegate
    private final ContentFactory.Content content;

    public Status404(ContentFactory contentFactory) {
        content = contentFactory.create("Not found", "error/${this.getClass().getSimpleName()}");
    }
}
