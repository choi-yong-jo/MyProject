package com.cafe.api.member.repository;

import com.cafe.api.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	public List<Member> findById(String id);

	public List<Member> findByName(String name);

	public List<Member> findByNameLike(String name);

}
