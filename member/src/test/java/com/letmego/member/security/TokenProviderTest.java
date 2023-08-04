package com.letmego.member.security;

import com.letmego.member.entity.MemberEntity;
import com.letmego.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class TokenProviderTest {

    @Test
    void create() {
        MemberEntity member = MemberEntity.builder()
                .memberId("ff80808189b027590189b027861f0000")
                .email("izocuna@gmail.com")
                .firstName("Jae Young")
                .lastName("Park")
                .password("P@ssw0rd")
                .build();





    }
}