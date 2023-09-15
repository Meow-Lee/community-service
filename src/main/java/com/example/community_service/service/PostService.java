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
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void createPost(PostDto postDto) {
        Post post = Post.builder().
                title(postDto.getTitle()).
                content(postDto.getContent()).
                created_at(LocalDateTime.now()).
                updated_at(LocalDateTime.now()).
                build();
        postRepository.save(post);
    }

    public Page<Post> getList(int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return postRepository.findAll(pageable);
    }

    public Post getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            post.orElseThrow(() -> new IllegalArgumentException("Post not found"));
        }
        return post.get();
    }
}
