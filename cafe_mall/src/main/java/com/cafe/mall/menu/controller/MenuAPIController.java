package com.cafe.mall.menu.controller;

import com.cafe.mall.menu.model.Menu;
import com.cafe.mall.menu.service.MenuService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/menu")
@Slf4j
public class MenuAPIController {

    @Resource(name="menuService")
    private MenuService menuService;

    // 모든 메뉴 조회
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Menu>> getAllmembers() {
        List<Menu> member = menuService.findAll();
        return new ResponseEntity<List<Menu>>(member, HttpStatus.OK);
    }

    // 메뉴 조회
    @GetMapping(value = "/{menuNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Menu> getMember(@PathVariable("menuNo") Integer menuNo) {
        Optional<Menu> menu = menuService.findById(menuNo);
        return new ResponseEntity<Menu>(menu.get(), HttpStatus.OK);
    }

    // 메뉴 삭제
    @DeleteMapping(value = "/{menuNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("menuNo") Integer menuNo) {
        menuService.deleteById(menuNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 메뉴 수정
    @PutMapping(value = "/{menuNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Menu> updateMember(@PathVariable("menuNo") Integer menuNo, @RequestBody Menu menu) {
        menuService.updateById(menuNo, menu);
        return new ResponseEntity<Menu>(menu, HttpStatus.OK);
    }

    // 메뉴 입력
    @PostMapping
    public ResponseEntity<Menu> save(@RequestBody Menu menu) {
        return new ResponseEntity<Menu>(menuService.save(menu), HttpStatus.CREATED);
    }

    // 메뉴 입력
    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<Menu> save(HttpServletRequest req, Menu menu) {
        return new ResponseEntity<Menu>(menuService.save(menu), HttpStatus.CREATED);
    }

}
