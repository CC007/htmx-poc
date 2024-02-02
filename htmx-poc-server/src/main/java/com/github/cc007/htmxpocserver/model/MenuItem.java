package com.github.cc007.htmxpocserver.model;

import lombok.Value;

@Value
public class MenuItem {
    String name;
    String url;
    boolean active;
}
