package com.cafe.api.menu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "menu_seq", sequenceName = "menu_seq", initialValue = 1, allocationSize = 1)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")	// Hibernate postgreSQL에서 PK 값 자동증가 처리
    private int menuNo;

    private String menuId;

    private String upMenuId;

    private String menuNm;

    @Column(name = "url")
    private String menuUrl;

}
