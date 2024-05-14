package com.cafe.api.member.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@MapperScan
@Repository
public interface UserMapper {

    ArrayList<HashMap<String, Object>> findAll();
}
