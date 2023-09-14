package com.example.community_service.service;

import com.example.community_service.domain.User;
import com.example.community_service.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("User Info Test")
    @Test
    public void test1() {
        User user1 = User.builder().name("Lee").age(15).email("lukei321@naver.com").build();
        User user2 = User.builder().name("Lee").age(15).email("lukei321@naver.com").build();

        memberService.saveMember(user1);
        memberService.saveMember(user2);

        assertThat(memberRepository.count()).isEqualTo(2);
    }
}