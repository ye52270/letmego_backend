package com.letmego.member.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
