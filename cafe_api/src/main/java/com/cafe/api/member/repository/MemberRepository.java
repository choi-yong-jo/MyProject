package com.cafe.api.member.repository;

import com.cafe.api.member.model.Member;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member save(Member member);

	List<Member> findById(String id);

	@Query("select sp_find_member_nm(%:member_nm%)")
	List<Member> findByName(@Param("member_nm") String name);

	List<Member> findByNameLike(String name);

}
