package com.github.cc007.htmxpocserver.components.content.error;

import com.github.cc007.htmxpocserver.components.ContentComponent;
import com.github.cc007.htmxpocserver.services.HtmxService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class Status404 extends ContentComponent {

    private final HtmxService htmxService;

    @Override
    protected String getTitle() {
        return "Not found";
    }
}
