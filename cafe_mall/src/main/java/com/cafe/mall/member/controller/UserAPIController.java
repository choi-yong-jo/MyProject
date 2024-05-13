package com.cafe.mall.member.controller;

import com.cafe.mall.member.dto.ResponseDTO;
import com.cafe.mall.member.model.CafeUser;
import com.cafe.mall.member.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/user")
@Slf4j
public class UserAPIController {

    @Resource(name="userService")
    UserService userService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(userService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CafeUser> save(@RequestBody CafeUser cafeUser) {
        return new ResponseEntity<CafeUser>(userService.save(cafeUser), HttpStatus.CREATED);
    }

}
