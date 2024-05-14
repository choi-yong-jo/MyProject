package com.cafe.api.board.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@MapperScan
@Repository
public interface BoardMapper {

    ArrayList<HashMap<String, Object>> findAll();

}
