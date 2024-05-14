package com.cafe.api.menu.service;

import com.cafe.api.menu.model.Menu;
import com.cafe.api.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional("transactionManager")
    public void deleteById(Integer menuNo){
        menuRepository.deleteById(menuNo);
    }

    @Transactional("transactionManager")
    public Menu save(Menu menu){
        menuRepository.save(menu);
        return menu;
    }

    @Transactional("transactionManager")
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
