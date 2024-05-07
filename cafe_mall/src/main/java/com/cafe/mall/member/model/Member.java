package com.cafe.mall.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	// Hibernate postgreSQL에서 PK 값 자동증가 처리
	private int mbrNo;

	@Column(name = "member_id")
	private String id;

	@Column(name = "member_pw")
	private String password;

	@Column(name = "member_nm")
	private String name;
	
	private String phone;
	
	private String email;

	@CreationTimestamp		// Hibernate에서 insert 쿼리가 발생 시 현재시간이 생성
	private LocalDateTime createDt;

	@UpdateTimestamp		// Hibernate에서 update 쿼리가 발생 시 현재시간이 생성
	private LocalDateTime updateDt;
}
