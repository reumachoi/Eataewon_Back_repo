package com.proj.eataewon.dto;

/*
 id varchar(50) not null,
    seq int ,
    title varchar(500) not null,
    content varchar(4000) not null,
    picture int,
    hashtag varchar(500),
    wdate timestamp,
    shopname varchar(100),
    address varchar(500),
    latitude number(12,8),
    longtitude number(12,8),
    readcnt int,
    likecnt int,
);
*/

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class BbsDto {

	private String id;
	private int seq;
	private String title;
	private String content;
	private int picture;
	private String hashtag;
	private String wdate;
	private String shopname;
	private String address;
	private double latitude;
	private double longtitude;
	private int readcnt;
	private int likecnt;

}
