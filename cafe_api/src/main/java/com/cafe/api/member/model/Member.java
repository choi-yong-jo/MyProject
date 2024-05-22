package com.cafe.api.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "member_seq", sequenceName = "member_seq", initialValue = 1, allocationSize = 1)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")	// Hibernate postgreSQL에서 PK 값 자동증가 처리
	private Long mbrNo;

	@Column(name = "member_id", nullable = false)
	@NotNull
	private String id;

	@Column(name = "member_pw", nullable = false)
	@NotNull
	private String password;

	@Column(name = "member_nm", nullable = false)
	@NotNull
	private String name;

	@Column(name = "mobile", nullable = false)
	@NotNull
	private String phone;
	
	private String email;

	private String zipcode;

	private String address;

	private String addressDetail;

	@CreationTimestamp		// Hibernate에서 insert 쿼리가 발생 시 현재시간이 생성
	private LocalDateTime createDt;

	private String createId;

	@UpdateTimestamp		// Hibernate에서 update 쿼리가 발생 시 현재시간이 생성
	private LocalDateTime updateDt;

	private String updateId;

}
