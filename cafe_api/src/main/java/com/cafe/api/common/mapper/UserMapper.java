package com.cafe.api.common.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@MapperScan
@Repository
public interface UserMapper {

    ArrayList<HashMap<String, Object>> findAll();
}
