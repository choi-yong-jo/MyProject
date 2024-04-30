package com.cafe.mall;

import com.cafe.mall.board.model.Board;
import com.cafe.mall.board.service.BoardService;
import com.cafe.mall.member.model.Member;
import com.cafe.mall.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void getListTest(){
        List<Board> list = boardService.getList();
        System.out.println("list = " + list);
        assertEquals(list.size(), 10);
    }

    @BeforeEach
    public void init(){
        for(Long i = 1L; i<=10; i++){
            Board b = new Board();
            b.setBno(i);
            b.setTitle("title"+i);
            b.setContent("content"+i);
            Member member = new Member();
            member.setId("aaa");
            memberRepository.save(member);

            b.setMember(member);
            b.setViewCnt(0);
            b.setInDate(new Date());
            b.setUpDate(new Date());
            boardService.write(b);
        }
    }

    @Test
    public void writeAndReadTest(){
        Member member = new Member();
        member.setId("bbb");
        memberRepository.save(member);

        Board b = new Board();
        b.setBno(11L);
        b.setTitle("new Title");
        b.setContent("new Content");
        b.setMember(member);
        b.setViewCnt(0);
        b.setInDate(new Date());
        b.setUpDate(new Date());
        boardService.write(b);

        Board b2 = boardService.read(11L);
        assertTrue(b2 != null);
        assertEquals(b.getTitle(), b2.getTitle());
        assertEquals(b.getContent(), b2.getContent());
    }

    @Test
    public void modifyTest(){
        Board board = boardService.read(1L);
        board.setTitle("modifed title");
        board.setContent("modifed content");
        boardService.modify(board);

        Board board2 = boardService.read(1L);
        assertEquals(board.getTitle(), board2.getTitle());
        assertEquals(board.getContent(), board2.getContent());
    }

    @Test
    public void removeTest(){
        Long bno = 5L;
        assertTrue(boardService.read(bno)!=null);
        boardService.remove(bno);
        assertEquals(boardService.read(bno), null);


    }

}