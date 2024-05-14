package com.cafe.api.board.controller;

import com.cafe.api.board.model.Board;
import com.cafe.api.board.service.BoardService;
import com.cafe.api.board.dto.BoardResponseDTO;
import com.cafe.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        BoardResponseDTO responseDTO = new BoardResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(boardService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Board board){
        boardService.save(board);
        return ResponseEntity.ok("성공");
    }

}
