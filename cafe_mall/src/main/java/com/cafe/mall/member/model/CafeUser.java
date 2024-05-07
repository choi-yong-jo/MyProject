package com.cafe.mall.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cafe_user")
public class CafeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	// Hibernate postgreSQL에서 PK 값 자동증가 처리
    private int userNo;

    private String userId;

    private String userPw;

    private String userNm;

}
