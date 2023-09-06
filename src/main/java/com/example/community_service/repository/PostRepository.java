package com.example.community_service.repository;

import com.example.community_service.domain.Post;
import com.example.community_service.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
