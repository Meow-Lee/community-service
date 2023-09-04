package com.example.community_service.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Post_id")
    private Long id;

    @Column(name = "Title", nullable = false)
    private String post_title;

    @Column(name = "Content", nullable = false)
    private String post_content;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime post_createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime post_updatedAt;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Member postMember;

    @Builder
    public Post(String post_title, String post_content, LocalDateTime post_createdAt) {
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_createdAt = post_createdAt;
    }
}
