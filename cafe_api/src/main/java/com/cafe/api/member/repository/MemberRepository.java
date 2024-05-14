package com.cafe.api.member.repository;

import com.cafe.api.member.model.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member save(Member member);

	public List<Member> findById(String id);

	public List<Member> findByName(String name);

	public List<Member> findByNameLike(String name);

}
