package com.cafe.mall.member.repository;

import com.cafe.mall.member.model.CafeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeUserRepository extends JpaRepository<CafeUser, Integer> {
}
