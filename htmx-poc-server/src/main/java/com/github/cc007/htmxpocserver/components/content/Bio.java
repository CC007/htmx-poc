package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.Component;
import com.github.cc007.htmxpocserver.spring.SpringComponent;
import lombok.Getter;
import lombok.experimental.Delegate;

@SpringComponent
@Getter
public class Bio implements Component {

    @Delegate
    private ContentFactory.Content content;

    public Bio(ContentFactory contentFactory) {
        content = contentFactory.create("Bio", this.getClass().getSimpleName());
    }
}
