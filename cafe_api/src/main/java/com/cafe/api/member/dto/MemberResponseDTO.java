package com.cafe.api.member.dto;

import lombok.Data;

@Data
public class MemberResponseDTO {
    private String resultCode;
    private String msg;
    private Object res;
}
