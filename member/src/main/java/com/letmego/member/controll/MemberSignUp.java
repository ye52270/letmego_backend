package com.letmego.member.controll;

import com.letmego.member.dto.ResponseDTO;
import com.letmego.member.service.MemberRegister;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberSignUp {
    private final MemberRegister memberRegister;

    @GetMapping(path = "/member")
    public String getMember(){
        return Optional.ofNullable(memberRegister.getMember())
                .orElse("error");
    }

    @PostMapping(path = "/member")
    public ResponseEntity<ResponseDTO> postMember(
            @RequestBody ResponseDTO body
    ) {
        log.info(body.toString());
        return ResponseEntity.ok(body);
    }
}
