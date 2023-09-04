package com.example.community_service.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Comment_id")
    private Long comment_id;

    @Column(name = "Title", nullable = false)
    private String comment_title;

    @Column(name = "Content", nullable = false)
    private String comment_content;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime comment_createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime comment_updatedAt;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Member commentMember;

    @Builder
    public Comment(String comment_title, String comment_content, LocalDateTime comment_createdAt) {
        this.comment_title = comment_title;
        this.comment_content = comment_content;
        this.comment_createdAt = comment_createdAt;
    }
}
