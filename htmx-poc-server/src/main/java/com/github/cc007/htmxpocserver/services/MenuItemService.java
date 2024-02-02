package com.github.cc007.htmxpocserver.services;

import com.github.cc007.htmxpocserver.model.MenuItem;
import com.github.cc007.htmxpocserver.model.MenuItemType;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    public List<MenuItem> getMenuItems(MenuItemType activeItem) {
        return List.of(
                new MenuItem("Bio", "/bio", MenuItemType.BIO.equals(activeItem)),
                new MenuItem("Portfolio", "/portfolio", MenuItemType.PORTFOLIO.equals(activeItem)),
                new MenuItem("Socials", "/socials", MenuItemType.SOCIALS.equals(activeItem))
        );
    }
}