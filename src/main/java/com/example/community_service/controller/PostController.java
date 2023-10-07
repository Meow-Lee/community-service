package com.example.community_service.controller;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * write post
     *
     * @param model
     * @param postDto
     * @return post
     */
    @GetMapping("/write")
    public String write(Model model, PostDto postDto) {
        model.addAttribute("post", postDto);
        return "post";
    }

    /**
     * submit post with dto
     *
     * @param postDto
     * @return redirect
     */
    @PostMapping
    public String post(@Valid PostDto postDto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/home/board";
        }

        PostDto dto = new PostDto();
        dto.setTitle(postDto.getTitle());
        dto.setContent(postDto.getContent());
        postService.createPost(dto);
        return "redirect:/home/board";
    }

    @GetMapping("/detail/{id}")
    public String postForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("post_detail", postService.getPost(id));
        return "post_detail";
    }
}
