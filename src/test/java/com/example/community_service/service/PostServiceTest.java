package com.example.community_service.service;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @DisplayName("게시글 저장 테스트")
    @Test
    public void test1() {
        PostDto post1 = new PostDto();
        post1.setTitle("1");
        post1.setContent("hi");

        PostDto post2 = new PostDto();
        post2.setTitle("2");
        post2.setContent("hifadf");

        postService.createPost(post1);
        postService.createPost(post2);

        assertThat(postRepository.count()).isEqualTo(2);
    }
}