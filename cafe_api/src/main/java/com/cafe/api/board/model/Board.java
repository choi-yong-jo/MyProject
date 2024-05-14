package com.cafe.api.board.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", initialValue = 1, allocationSize = 1)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")     // 자동 번호 증가
    private Long bno;   // 게시물 번호

    private String title;

    private String writer;

    private String content;

    private int viewCnt;

    private int mbrNo;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime inDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime upDate;

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", mbrNo=" + mbrNo +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }

}
