package com.sungwon.api.member.repository;

import com.sungwon.api.member.entity.Role;
import com.sungwon.api.common.repository.GenericRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends GenericRepository<Role>, QuerydslPredicateExecutor<Role> {

	Role findTopByRoleId(String roleId);

	Optional<Role> findByRoleIdAndName(String roleId, String roleNm);

	Iterable<Object> findByUseYnOrderByRoleSeq(String useYn);

	Optional<Role> findByRoleSeq(Long roleSeq);
}
