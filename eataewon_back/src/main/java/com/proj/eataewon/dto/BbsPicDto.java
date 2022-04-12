package com.proj.eataewon.dto;

/* picture을 string으로 저장
create table eataewonBbsPic(
    id varchar(50) not null,
    seq int ,
    title varchar(500) not null,
    content varchar(4000) not null,
    picture varchar(500) not null,
    hashtag varchar(500),
    wdate timestamp,
    shopname varchar(100),
    address varchar(500),
    latitude number(12,8),
    longtitude number(12,8),
    readcnt int,
    likecnt int,
    constraint pk_eataewonBbsPic primary key(seq)
);
*/

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class BbsPicDto {

	private String id;
	private int seq;
	private String title;
	private String content;
	private String picture;

	private String hashtag;
	private String wdate;
	private String shopname;
	private String address;
	private double latitude;
	private double longitude;
	private int readcnt;
	private int likecnt;

	private String name;
	private String pwd;
	private String email;
	private String nickName;
	private String profilPic;
	private int likePoint;
	private String profilMsg;
}
