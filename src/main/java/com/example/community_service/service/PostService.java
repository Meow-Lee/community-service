package com.example.community_service.service;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import com.example.community_service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Post> getList(int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return postRepository.findAll(pageable);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
