package com.letmego.member.service;

import com.letmego.member.entity.MemberEntity;
import com.letmego.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository repository;

    public String getMember() {
        return "member";
    }

    public MemberEntity createMember(MemberEntity memberEntity) {
        MemberEntity member = MemberEntity.builder()
                .firstName(memberEntity.getFirstName())
                .lastName(memberEntity.getLastName())
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .role(memberEntity.getRole())
                .build();

        log.info("request DTO : " + memberEntity.toString());

        return repository.save(member);
    }

    public MemberEntity getByCredentials(
            final String email,
            final String password,
            final PasswordEncoder passwordEncoder) {
        final MemberEntity originalMember = repository.findByEmail(email);

        if(originalMember != null &&
                passwordEncoder.matches(password, originalMember.getPassword())) {
            return originalMember;
        }
        return null;
    }
}


