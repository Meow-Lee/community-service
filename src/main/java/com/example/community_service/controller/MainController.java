package com.example.community_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }

    @GetMapping("/board/write")
    public String write() {
        return "post";
    }
}
