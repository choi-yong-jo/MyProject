package com.cafe.api.member.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MemberRequestDTO {

    private Integer mbrNo;

    @Column(name = "member_id", nullable = false)
    private String id;
}
