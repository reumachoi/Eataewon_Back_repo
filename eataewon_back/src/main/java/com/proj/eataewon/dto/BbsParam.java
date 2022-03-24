package com.proj.eataewon.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor //생성자
public class BbsParam {

    private String choice; //제목, 내용,작성자, +)해쉬태그
    private String search; //검색어

    private int page; //현재 페이지

    private int start; //페이지 글의 범위
    private int end;

}
