package com.cafe.api.member.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MemberRequestDTO {

    private Integer mbrNo;

    @Column(name = "member_id")
    private String id;

    @Column(name = "member_nm")
    private String name;
}
