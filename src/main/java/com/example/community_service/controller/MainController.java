package com.example.community_service.controller;

import com.example.community_service.dto.PostDto;
import com.example.community_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {
    @Autowired
    private PostService postService;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }

    @GetMapping("/board/write")
    public String write(Model model, PostDto postDto) {
        model.addAttribute(postDto);
        return "write";
    }

    @PostMapping("/board/write")
    public String post(@ModelAttribute PostDto postDto) {
        postService.postSave(postDto);
        return "redirect:/home/board";
    }
}
