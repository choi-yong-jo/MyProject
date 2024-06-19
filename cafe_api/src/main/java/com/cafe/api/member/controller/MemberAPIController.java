package com.cafe.api.member.controller;

import com.cafe.api.member.dto.MemberRequestDTO;
import com.cafe.api.member.dto.MemberResponseDTO;
import com.cafe.api.member.model.Member;
import com.cafe.api.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/member")
@Slf4j
public class MemberAPIController {

    @Autowired
    MemberService memberService;

    // 모든 회원 조회
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getAllmembers() {
        List<Member> member = memberService.findAll();
//        return new ResponseEntity<List<Member>>(member, HttpStatus.OK);

        MemberResponseDTO responseDTO = new MemberResponseDTO();
        if (member == null) {
            responseDTO.setMsg("조회된 데이터가 없습니다.");
        } else {
            responseDTO.setRes(member);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/select", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> searchMember(@RequestBody MemberRequestDTO requestDTO) {
        List<Member> list = new ArrayList<>();
        if (requestDTO == null) {
            list = memberService.findAll();
        } else {
            Optional<Member> member = memberService.findById(requestDTO.getMbrNo());
            list = member.stream().toList();
        }

        MemberResponseDTO responseDTO = new MemberResponseDTO();
        if (list == null) {
            responseDTO.setMsg("조회된 데이터가 없습니다.");
        } else {
            responseDTO.setRes(list);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Member> getMember(@PathVariable("mbrNo") Integer mbrNo) {
        Optional<Member> member = memberService.findById(mbrNo);
        return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/findNm")
    public List<Member> getMembers(@RequestBody Member member) {
        List<Member> members = memberService.findByNm(member);
        return members;
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Integer mbrNo) {
        memberService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name로 수정함)
    @PutMapping(value = "/update/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Member> updateMember(@PathVariable("mbrNo") Integer mbrNo, @RequestBody Member member) {
        memberService.updateById(mbrNo, member);
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    // 회원 입력
    @PostMapping
    public ResponseEntity<Member> save(@RequestBody Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.CREATED);
    }

    // 회원 입력
    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public ResponseEntity<?> saveMember(@RequestBody Member member) {
        MemberResponseDTO responseDTO = new MemberResponseDTO();
        Member member1 = memberService.save(member);
        if (member1 != null) {
            responseDTO.setResultCode("200");
            responseDTO.setMsg("등록되었습니다.");
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
