package com.cafe.mall.menu.service;

import com.cafe.mall.member.model.Member;
import com.cafe.mall.menu.model.Menu;
import com.cafe.mall.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findAll() {
        List<Menu> menuList = new ArrayList<>();
        menuRepository.findAll().forEach(e -> menuList.add(e));
        return menuList;
    }

    public Optional<Menu> findById(Integer menuNo) {
        Optional<Menu> menu = menuRepository.findById(menuNo);
        return menu;
    }

    public void deleteById(Integer menuNo){
        menuRepository.deleteById(menuNo);
    }

    public Menu save(Menu menu){
        menuRepository.save(menu);
        return menu;
    }

    public void updateById(Integer menuNo, Menu menu){
        Optional<Menu> e = menuRepository.findById(menuNo);
        if(e.isPresent()){
            e.get().setUpMenuId(menu.getUpMenuId());
            e.get().setMenuNm(menu.getMenuNm());
            e.get().setMenuUrl(menu.getMenuUrl());
            menuRepository.save(menu);
        }
    }

}
