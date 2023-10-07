package com.example.community_service.controller;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class MainController {
    
    private final PostService postService;
    /**
     * main page
     * @return home
     */
    @GetMapping
    public String home() {
        return "home";
    }

    /**
     * to the post lists
     *
     * @return board
     */
    @GetMapping("/board")
    public String board(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Post> paging = postService.getList(page);
        model.addAttribute("postList", paging);
        return "board";
    }
}
