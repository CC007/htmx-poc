package com.github.cc007.htmxpocserver.controllers;

import com.github.cc007.htmxpocserver.components.content.Bigben;
import com.github.cc007.htmxpocserver.model.MenuItemType;
import com.github.cc007.htmxpocserver.services.MenuItemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BigBenController {

    public static final int HEIGHT_PER_POST = 202;

    private final MenuItemService menuItemService;
    private final Bigben bigben;

    @GetMapping("/bigben")
    public String bigBen(@RequestParam Optional<Integer> viewportHeight,
                         @RequestParam("offset") Optional<Integer> optOffset,
                         @RequestParam Optional<Long> timestamp,
                         HttpServletRequest request,
                         HttpServletResponse response,
                         Model model
    ) {
        response.setHeader("Cache-Control", "max-age=60, stale-while-revalidate=600");
        response.setHeader("Vary", "HX-Request");
        Instant time = timestamp.map(Instant::ofEpochSecond)
                                .orElse(Instant.now())
                                .atZone(ZoneOffset.UTC)
                                .withMinute(0)
                                .withSecond(0)
                                .toInstant();
        int postCount = viewportHeight.map(vh -> vh / HEIGHT_PER_POST).orElse(20);
        int offset = optOffset.orElse(0);
        if (offset >= 120) {
            postCount = 0;
        }

        model.addAttribute("timestamp", time.getEpochSecond())
             .addAttribute("currentHour", time.atZone(ZoneOffset.UTC).minusHours(offset).getHour())
             .addAttribute("nextOffset", offset + postCount)
             .addAttribute("postCount", postCount)
             .addAttribute("showDescription", offset == 0);

        model.addAttribute("menuItems", menuItemService.getMenuItems(MenuItemType.PORTFOLIO));
        if (optOffset.isPresent()) {
            log.info("Found offset of ${offset}, returning ${postCount} bigben posts");
        } else {
            log.info("returning bigben page with first ${postCount} posts");
        }

        return bigben.getTemplateName(request, model);
    }
}
