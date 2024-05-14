package com.cafe.api.member.service;

import com.cafe.api.member.mapper.UserMapper;
import com.cafe.api.member.model.CafeUser;
import com.cafe.api.member.repository.CafeUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private CafeUserRepository cafeUserRepository;

    public ArrayList<HashMap<String, Object>> findAll() {
        return userMapper.findAll();
    }

    @Transactional
    public CafeUser save(CafeUser cafeUser){
        cafeUser.setCreateDt(LocalDateTime.now());
        cafeUserRepository.save(cafeUser);
        return cafeUser;
    }

}
