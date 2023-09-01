package com.example.community_service.service;

import com.example.community_service.domain.Member;
import com.example.community_service.repository.MemberRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    // 사용자 정보 저장
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    // 사용자 정보 조회
    public Member findMemberById(Long id) { // 사용자 정보가 없을 경우 예외 터트림
        Optional<Member> member = memberRepository.findById(id);
        return member.orElseThrow(() -> new IllegalArgumentException("Member Not Found"));
    }

    public List<Member> findMembers() {
        return memberRepository.findAll().stream().toList();
    }

    // 사용자 정보 수정
    public void updateMember(Member member) {
        Member member1 = findMemberById(member.getId());

        member1.builder()
                .name(member.getName())
                .age(member.getAge())
                .email(member.getEmail())
                .address(member.getAddress()).build();
    }

    // 사용자 정보 삭제
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }
}
