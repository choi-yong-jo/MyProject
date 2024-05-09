package com.cafe.mall.menu.repository;

import com.cafe.mall.menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
