package com.github.cc007.htmxpocserver.components.content;

import com.github.cc007.htmxpocserver.components.ContentComponent;
import com.github.cc007.htmxpocserver.services.HtmxService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class Home extends ContentComponent {

    private final HtmxService htmxService;

    @Override
    protected String getTitle() {
        return "Homepage";
    }
}
