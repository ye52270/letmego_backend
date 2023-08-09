package com.letmego.member.controll;

import com.letmego.member.dto.ResponseDTO;
import com.letmego.member.dto.UserDTO;
import com.letmego.member.entity.MemberEntity;
import com.letmego.member.security.TokenProvider;
import com.letmego.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class MemberController {
    private final MemberService memberService;
    private final TokenProvider tokenProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping(path = "/signup")
    public ResponseEntity<?> postMember(
            @RequestBody UserDTO userDTO
    ) {
        try {
            if (userDTO == null || userDTO.getPassword() == null) {
                throw new RuntimeException("Invalid User Info");
            }
            log.info("User DTO : " + userDTO);

            MemberEntity member = MemberEntity
                    .builder()
                    .firstName(userDTO.getFirstName())
                    .lastName(userDTO.getLastName())
                    .email(userDTO.getEmail())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .role(userDTO.getUserRole())
                    .build();

            MemberEntity createdMember = memberService.createMember(member);

            UserDTO responseDTO = UserDTO.builder()
                    .memberId(createdMember.getMemberId())
                    .firstName(createdMember.getFirstName())
                    .lastName(createdMember.getLastName())
                    .email(createdMember.getEmail())
                    .userRole(createdMember.getRole())
                    .build();

            log.info("member created ------ : " + createdMember.toString());
            return ResponseEntity.ok(responseDTO);

        } catch (Exception e) {
            ResponseDTO<Object> responseDTO =
                    ResponseDTO
                            .builder()
                            .error(e.getMessage())
                            .build();

            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

    @PostMapping(path = "/signin")
    public ResponseEntity<?> authenticate(
            @RequestBody UserDTO userDTO
    ) {

        log.info("-------- RequestBody DTO -----------" + userDTO.toString());

        MemberEntity member = memberService.getByCredentials(
                userDTO.getEmail(),
                userDTO.getPassword(),
                passwordEncoder);
        log.info("find member : " + member.toString());

        if (member != null) {
            final String token = tokenProvider.create(member);

            UserDTO memberDto = UserDTO.builder()
                    .firstName(member.getFirstName())
                    .lastName(member.getLastName())
                    .email(member.getEmail())
                    .memberId(member.getMemberId())
                    .userRole(member.getRole())
                    .token(token)
                    .build();

            return ResponseEntity
                    .ok()
                    .body(memberDto);
        }else{
            ResponseDTO<Object> responseDTO = ResponseDTO.builder()
                    .error("Login Failed.")
                    .build();

            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }

    }
}
