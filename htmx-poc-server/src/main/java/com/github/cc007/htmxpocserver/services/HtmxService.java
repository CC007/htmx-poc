package com.github.cc007.htmxpocserver.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class HtmxService {

    public boolean isHtmxRequest(HttpServletRequest request) {
        return "true".equals(request.getHeader("HX-Request"));
    }
}