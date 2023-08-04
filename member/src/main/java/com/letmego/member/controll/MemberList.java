package com.letmego.member.controll;

import com.letmego.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberList {
    private final MemberRepository repository;

    @GetMapping(path = "/member")
    public ResponseEntity<?> getMember(@AuthenticationPrincipal String email) {

        System.out.println("getmember controller---------" + email);

        return ResponseEntity.ok().body("ok");
    }
}
