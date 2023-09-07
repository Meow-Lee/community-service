package com.example.community_service.service;

import com.example.community_service.domain.Member;
import com.example.community_service.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("User Info Test")
    @Test
    public void test1() {
        Member member1 = Member.builder().name("Lee").age(15).email("lukei321@naver.com").address("하남").build();
        Member member2 = Member.builder().name("Lee").age(15).email("lukei321@naver.com").address("하남").build();

        memberService.saveMember(member1);
        memberService.saveMember(member2);

        assertThat(memberRepository.count()).isEqualTo(2);
    }
}