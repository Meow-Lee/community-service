package com.example.community_service.controller;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class MainController {
    @Autowired
    private PostService postService;

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

    /**
     * write post
     * @param model
     * @param postDto
     * @return post
     */
    @GetMapping("/board/post")
    public String write(Model model, PostDto postDto) {
        model.addAttribute("post", postDto);
        return "post";
    }

    /**
     * submit post with dto
     * @param postDto
     * @return
     */
    @PostMapping("/board/post")
    public String post(@ModelAttribute PostDto postDto) {
        postService.postSave(postDto);
        return "redirect:/home/board";
    }
}
