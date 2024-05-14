package com.cafe.api.member.repository;

import com.cafe.api.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member save(Member member);

	List<Member> findById(String id);

	List<Member> findByName(String name);

	List<Member> findByNameLike(String name);

}
