package com.example.community_service.init;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.service.PostService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestData {

    private final PostService postService;

    // insert test data
    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            PostDto postDto = new PostDto();
            postDto.setTitle("title" + i);
            postDto.setContent("content " + i);

            postService.createPost(postDto);
        }
    }
}
