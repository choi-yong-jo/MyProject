package com.cafe.api.member.repository;

import com.cafe.api.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member save(Member member);

	List<Member> findById(String id);

//	@Procedure(procedureName = "sp_find_member_nm")
	@Query(value = "select sp_find_member_nm(:#{#member.name})", nativeQuery = true)
//	@Query(value = "select m from Member m where m.name like :#{#member.name}||'%'")
	List<Member> searchMemberNm(@Param(value = "member") Member member);

	List<Member> findByNameLike(String name);

}
