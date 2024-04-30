package com.cafe.mall.board.model;

import com.cafe.mall.member.model.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     // 자동 번호 증가
    private Long bno;   // 게시물 번호

    private String title;

    private String writer;

    private String content;

    private int viewCnt;

    @ManyToOne      // 여러 개 board의 하나의 User. FK 자동 생성
    @JoinColumn(name="member_id", nullable = false)
    private Member member;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date inDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date upDate;

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
//                ", user=" + user +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }

}
