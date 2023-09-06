package com.example.community_service.service;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void postSave(PostDto postDto) {
        Post post = Post.builder().
                post_title(postDto.getTitle()).
                post_content(postDto.getContent()).
                post_createdAt(LocalDateTime.now()).
                post_updatedAt(LocalDateTime.now()).
                build();
        postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
