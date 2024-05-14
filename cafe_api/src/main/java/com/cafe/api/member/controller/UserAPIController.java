package com.cafe.api.member.controller;

import com.cafe.api.member.dto.ResponseDTO;
import com.cafe.api.member.model.CafeUser;
import com.cafe.api.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/user")
public class UserAPIController {

    @Autowired
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
