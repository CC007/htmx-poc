package com.github.cc007.htmxpocserver.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import lombok.SneakyThrows;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ArtificialDelayFilter implements Filter {

    @Override
//    @SneakyThrows(InterruptedException.class)
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        //Thread.sleep(1000);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
