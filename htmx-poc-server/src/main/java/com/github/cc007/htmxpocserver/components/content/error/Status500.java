package com.github.cc007.htmxpocserver.components.content.error;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.components.content.ContentFactory;
import com.github.cc007.htmxpocserver.spring.SpringComponent;
import lombok.Getter;
import lombok.experimental.Delegate;

@SpringComponent
@Getter
public class Status500 implements Component {

    @Delegate
    private ContentFactory.Content content;

    public Status500(ContentFactory contentFactory) {
        content = contentFactory.create("Error", "error/${this.getClass().getSimpleName()}");
    }
}
