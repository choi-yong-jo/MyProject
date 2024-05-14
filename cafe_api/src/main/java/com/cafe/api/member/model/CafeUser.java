package com.cafe.api.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cafe_user")
@SequenceGenerator(name = "cafe_user_seq", sequenceName = "cafe_user_seq", initialValue = 1, allocationSize = 1)
public class CafeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cafe_user_seq")	// Hibernate postgreSQL에서 PK 값 자동증가 처리
    private int userNo;

    private String userId;

    private String userPw;

    private String userNm;

    @CreationTimestamp        // Hibernate에서 insert 쿼리가 발생 시 현재시간이 생성
    private LocalDateTime createDt;

}
