package com.example.community_service.service;

import com.example.community_service.domain.User;
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
    public void saveMember(User user) {
        memberRepository.save(user);
    }

    // 사용자 정보 조회
    public User findMemberById(Long id) { // 사용자 정보가 없을 경우 예외 터트림
        Optional<User> member = memberRepository.findById(id);
        return member.orElseThrow(() -> new IllegalArgumentException("Member Not Found"));
    }

    public List<User> findMembers() {
        return memberRepository.findAll().stream().toList();
    }

    // 사용자 정보 수정
//    public void updateMember(User user) {
//        User user1 = findMemberById(user.getId());
//
//        user1.builder()
//                .name(user.getName())
//                .age(user.getAge())
//                .email(user.getEmail())
//                .address(user.getAddress()).build();
//    }

    // 사용자 정보 삭제
    public void deleteMember(User user) {
        memberRepository.delete(user);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }
}
