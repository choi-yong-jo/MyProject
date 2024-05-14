package com.cafe.api.member.repository;

import com.cafe.api.member.model.CafeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeUserRepository extends JpaRepository<CafeUser, Integer> {
}
