package com.cafe.api.board.service;

import com.cafe.api.board.mapper.BoardMapper;
import com.cafe.api.board.repository.BoardRepository;
import com.cafe.api.board.model.Board;
import com.cafe.api.member.model.Member;
import com.cafe.api.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Service
@Slf4j
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    MemberService memberService;

    public ArrayList<HashMap<String, Object>> findAll() {
        return boardMapper.findAll();
    }

    @Transactional("transactionManager")
    public void save(Board board){
        board.setInDate(LocalDateTime.now());
        boardRepository.save(board);

        Member member = new Member();
        member.setId("pide");
        member.setPassword("1004");
        member.setName("test");
        memberService.save(member);
    }

}
