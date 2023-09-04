package com.example.community_service.service;

import com.example.community_service.dto.PostDto;
import com.example.community_service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void postSave(PostDto postDto) {
        postRepository.save(postDto);
    }
}
