package com.letmego.member.dto;

import com.letmego.member.entity.MemberEntity;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseDTO<T> {
    private String error;
    private List<T> data;

}
