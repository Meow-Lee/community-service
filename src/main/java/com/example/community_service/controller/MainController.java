package com.example.community_service.controller;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String board(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("postList", posts);
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
        model.addAttribute(postDto);
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
