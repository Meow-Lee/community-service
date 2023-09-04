package com.example.community_service.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Member_id")
    private Long id;

    @Column(name = "Member_name", nullable = false)
    private String name;

    @Column(name = "Member_age", nullable = false)
    private int age;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "postMember")
    private List<Post> postList;

    @OneToMany(mappedBy = "commentMember")
    private List<Comment> commentList;

//    @Column(nullable = false)
//    private String login_id;
//
//    @Column(nullable = false)
//    private String login_password;

    @Builder
    public Member(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }
}
