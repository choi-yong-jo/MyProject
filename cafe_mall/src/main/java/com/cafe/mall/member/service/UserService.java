package com.cafe.mall.member.service;

import com.cafe.mall.common.mapper.UserMapper;
import com.cafe.mall.member.model.CafeUser;
import com.cafe.mall.member.repository.CafeUserRepository;
import com.cafe.mall.member.repository.MemberRepository;
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

    public CafeUser save(CafeUser cafeUser){
        cafeUser.setCreateDt(LocalDateTime.now());
        cafeUserRepository.save(cafeUser);
        return cafeUser;
    }

}
